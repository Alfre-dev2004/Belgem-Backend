-- 02_constraints.sql
-- Constraints (idempotente)

DO $$
BEGIN
  -- Representantes: UNIQUE codigointerno
  IF NOT EXISTS (SELECT 1 FROM pg_constraint WHERE conname = 'uq_representante_codigointerno') THEN
ALTER TABLE belgem.representantes
    ADD CONSTRAINT uq_representante_codigointerno UNIQUE (codigointerno);
END IF;

  -- Clientes: UNIQUE nif (para ON CONFLICT)
  IF NOT EXISTS (SELECT 1 FROM pg_constraint WHERE conname = 'uq_cliente_nif') THEN
ALTER TABLE belgem.cliente
    ADD CONSTRAINT uq_cliente_nif UNIQUE (nif);
END IF;

  -- Currencies (Divisas): UNIQUE code
  IF NOT EXISTS (SELECT 1 FROM pg_constraint WHERE conname = 'uq_currencies_code') THEN
ALTER TABLE belgem.currencies
    ADD CONSTRAINT uq_currencies_code UNIQUE (code);
END IF;

  -- Tipo Movimiento: nombre único
  IF NOT EXISTS (SELECT 1 FROM pg_constraint WHERE conname = 'uq_tipo_movimiento_nombre') THEN
ALTER TABLE belgem.tipo_movimiento
    ADD CONSTRAINT uq_tipo_movimiento_nombre UNIQUE (nombre);
END IF;
END $$ LANGUAGE plpgsql;
