-- ====================================================================
-- 02_constraints.sql
-- Constraints globales del proyecto Belgem
-- ====================================================================

-- ==========================
-- DIVISAS
-- ==========================
ALTER TABLE belgem.divisas
    ADD CONSTRAINT uq_divisa_code UNIQUE (code);

-- ==========================
-- REPRESENTANTES
-- ==========================
ALTER TABLE belgem.representantes
    ADD CONSTRAINT uq_representante_codigointerno UNIQUE (codigointerno);

-- ==========================
-- CLIENTES
-- ==========================
ALTER TABLE belgem.cliente
    ADD CONSTRAINT uq_cliente_nif UNIQUE (nif);

ALTER TABLE belgem.cliente
    ADD CONSTRAINT fk_cliente_representante
        FOREIGN KEY (representante_id)
            REFERENCES belgem.representantes(id);

-- ==========================
-- ARTICULOS
-- (aquí puedes añadir constraints si hacéis name UNIQUE, etc.)
-- ==========================

-- ==========================
-- ALMACENES
-- (Ahora no tiene constraints adicionales, salvo NOT NULL de nombre)
-- ==========================
