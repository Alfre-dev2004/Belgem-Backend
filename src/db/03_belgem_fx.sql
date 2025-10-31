-- =========================================================
-- belgem_fx.sql  (v1)
-- Esquema de divisas + carteras con margen y conversión
-- Crea todo en el schema "belgem" y es re-ejecutable.
-- =========================================================

-- 0) Preparación
CREATE SCHEMA IF NOT EXISTS belgem;
SET search_path TO belgem, public;

-- Limpieza idempotente de vistas/funciones (por si re-ejecutas)
DROP VIEW  IF EXISTS logical_currencies CASCADE;
DROP VIEW  IF EXISTS fx_rates_with_margin CASCADE;
DROP VIEW  IF EXISTS fx_rates_latest CASCADE;
DROP FUNCTION IF EXISTS fx_convert(numeric, text, text, belgem.margin_use);

-- 1) Tipos ENUM (si no existen)
DO $$
BEGIN
  IF NOT EXISTS (SELECT 1 FROM pg_type WHERE typname = 'margin_use') THEN
    CREATE TYPE margin_use AS ENUM ('compra','venta');
  END IF;
  IF NOT EXISTS (SELECT 1 FROM pg_type WHERE typname = 'cartera_tipo') THEN
    CREATE TYPE cartera_tipo AS ENUM ('cliente','proveedor','representante');
  END IF;
END $$;

-- 2) Tablas principales
CREATE TABLE IF NOT EXISTS currencies (
  id    SERIAL PRIMARY KEY,
  code  TEXT UNIQUE NOT NULL CHECK (length(code) BETWEEN 3 AND 6), -- EUR, USD, etc.
  name  TEXT NOT NULL
);

-- 1 EUR = rate * CODE  (p.ej. 1 EUR = 1.09 USD -> rate = 1.09)
CREATE TABLE IF NOT EXISTS fx_rates (
  id           BIGSERIAL PRIMARY KEY,
  currency_id  INT NOT NULL REFERENCES currencies(id) ON DELETE CASCADE,
  rate         NUMERIC(18,8) NOT NULL CHECK (rate > 0),
  valid_on     DATE NOT NULL,
  source       TEXT,
  CONSTRAINT uq_fx UNIQUE (currency_id, valid_on)
);

CREATE TABLE IF NOT EXISTS margin_rules (
  id           SERIAL PRIMARY KEY,
  currency_id  INT NOT NULL REFERENCES currencies(id) ON DELETE CASCADE,
  use          margin_use NOT NULL,
  percent      NUMERIC(6,3) NOT NULL,  -- 10 = +10%
  active_from  DATE NOT NULL DEFAULT CURRENT_DATE,
  active_to    DATE,
  CONSTRAINT uq_margin UNIQUE (currency_id, use, active_from)
);

CREATE TABLE IF NOT EXISTS carteras (
  id            SERIAL PRIMARY KEY,
  nombre        TEXT NOT NULL,
  tipo          cartera_tipo NOT NULL,
  activa        BOOLEAN NOT NULL DEFAULT TRUE,
  currency_id   INT REFERENCES currencies(id),
  notas         TEXT
);

-- 3) Índices útiles
CREATE INDEX IF NOT EXISTS idx_fx_rates_currency_date ON fx_rates(currency_id, valid_on DESC);
CREATE INDEX IF NOT EXISTS idx_margin_rules_curr_use_from ON margin_rules(currency_id, use, active_from DESC);
CREATE INDEX IF NOT EXISTS idx_carteras_tipo ON carteras(tipo);

-- 4) Vistas
CREATE OR REPLACE VIEW fx_rates_latest AS
SELECT DISTINCT ON (r.currency_id)
  r.currency_id,
  r.rate,
  r.valid_on,
  r.source
FROM fx_rates r
ORDER BY r.currency_id, r.valid_on DESC;

CREATE OR REPLACE VIEW fx_rates_with_margin AS
SELECT
  c.id            AS currency_id,
  c.code,
  c.name,
  l.rate          AS rate_base,  -- 1 EUR = rate_base * CODE
  mr.use,
  mr.percent,
  (l.rate * (1 + COALESCE(mr.percent,0)/100.0)) AS rate_applied,
  l.valid_on
FROM currencies c
JOIN fx_rates_latest l ON l.currency_id = c.id
LEFT JOIN LATERAL (
  SELECT m.*
  FROM margin_rules m
  WHERE m.currency_id = c.id
    AND m.active_from <= CURRENT_DATE
    AND (m.active_to IS NULL OR m.active_to >= CURRENT_DATE)
  ORDER BY m.active_from DESC
  LIMIT 1
) mr ON TRUE;

-- Vista opcional para “USV” (dólar ventas) como pseudo-divisa
CREATE OR REPLACE VIEW logical_currencies AS
-- Base sin margen (equivalente a 'compra' implícita)
SELECT code, name, rate_base, NULL::margin_use AS use, rate_base AS rate_applied, valid_on
FROM fx_rates_with_margin
UNION ALL
-- 'USV' = USD con margen de venta
SELECT 'USV' AS code, 'VENTAS' AS name, rate_base, 'venta'::margin_use, rate_applied, valid_on
FROM fx_rates_with_margin
WHERE code='USD' AND use='venta';

-- 5) Función de conversión
CREATE OR REPLACE FUNCTION fx_convert(
  p_amount    NUMERIC,
  p_from_code TEXT,
  p_to_code   TEXT,
  p_use       belgem.margin_use DEFAULT NULL
)
RETURNS NUMERIC
LANGUAGE plpgsql AS
$$
DECLARE
  from_rate NUMERIC;
  to_rate   NUMERIC;
BEGIN
  -- FROM
  SELECT COALESCE(
    (SELECT CASE WHEN p_use IS NULL
                 THEN l.rate
                 ELSE (
                     SELECT l.rate * (1 + mr.percent/100.0)
                     FROM margin_rules mr
                     WHERE mr.currency_id = l.currency_id
                       AND mr.use = p_use
                       AND mr.active_from <= CURRENT_DATE
                       AND (mr.active_to IS NULL OR mr.active_to >= CURRENT_DATE)
                     ORDER BY mr.active_from DESC
                     LIMIT 1
                 )
           END
     FROM currencies c
     JOIN fx_rates_latest l ON l.currency_id = c.id
     WHERE c.code = p_from_code),
    1.0) INTO from_rate;

  -- TO
  SELECT COALESCE(
    (SELECT CASE WHEN p_use IS NULL
                 THEN l.rate
                 ELSE (
                     SELECT l.rate * (1 + mr.percent/100.0)
                     FROM margin_rules mr
                     WHERE mr.currency_id = l.currency_id
                       AND mr.use = p_use
                       AND mr.active_from <= CURRENT_DATE
                       AND (mr.active_to IS NULL OR mr.active_to >= CURRENT_DATE)
                     ORDER BY mr.active_from DESC
                     LIMIT 1
                 )
           END
     FROM currencies c
     JOIN fx_rates_latest l ON l.currency_id = c.id
     WHERE c.code = p_to_code),
    1.0) INTO to_rate;

  RETURN (p_amount / from_rate) * to_rate;
END;
$$;

-- 6) Seed de ejemplo (seguro de re-ejecutar)
INSERT INTO currencies (code, name) VALUES
  ('EUR','EURO'),
  ('USD','DÓLAR USA')
ON CONFLICT (code) DO NOTHING;

-- EUR base histórica
INSERT INTO fx_rates (currency_id, rate, valid_on, source)
SELECT id, 1.00000000, DATE '2014-04-01', 'manual'
FROM currencies WHERE code='EUR'
ON CONFLICT DO NOTHING;

-- USD histórico + reciente (ajusta fechas/rates a los reales que uséis)
INSERT INTO fx_rates (currency_id, rate, valid_on, source)
SELECT id, 1.00000000, DATE '2014-04-01', 'manual'
FROM currencies WHERE code='USD'
ON CONFLICT DO NOTHING;

INSERT INTO fx_rates (currency_id, rate, valid_on, source)
SELECT id, 1.09000000, DATE '2022-07-01', 'manual'
FROM currencies WHERE code='USD'
ON CONFLICT DO NOTHING;

-- Regla margen USD venta +10%
INSERT INTO margin_rules (currency_id, "use", percent, active_from)
SELECT id, 'venta', 10.0, DATE '2022-07-01'
FROM currencies WHERE code='USD'
ON CONFLICT ON CONSTRAINT uq_margin DO NOTHING;

-- Carteras mínimas de ejemplo
INSERT INTO carteras (nombre, tipo, activa, currency_id)
SELECT 'Clientes', 'cliente', TRUE, (SELECT id FROM currencies WHERE code='EUR')
WHERE NOT EXISTS (SELECT 1 FROM carteras WHERE nombre='Clientes');

INSERT INTO carteras (nombre, tipo, activa, currency_id)
SELECT 'Proveedores', 'proveedor', TRUE, (SELECT id FROM currencies WHERE code='USD')
WHERE NOT EXISTS (SELECT 1 FROM carteras WHERE nombre='Proveedores');

INSERT INTO carteras (nombre, tipo, activa, currency_id)
SELECT 'Representantes', 'representante', TRUE, (SELECT id FROM currencies WHERE code='EUR')
WHERE NOT EXISTS (SELECT 1 FROM carteras WHERE nombre='Representantes');

-- 7) Pruebas rápidas (puedes comentar esta sección en producción)
-- SELECT * FROM fx_rates_latest;
-- SELECT * FROM fx_rates_with_margin;
-- SELECT * FROM logical_currencies;
-- SELECT fx_convert(100, 'USD','EUR', NULL)   AS usd_to_eur_compra;
-- SELECT fx_convert(100, 'USD','EUR','venta') AS usd_to_eur_venta;
-- SELECT fx_convert(100, 'EUR','USD','venta') AS eur_to_usd_venta;
