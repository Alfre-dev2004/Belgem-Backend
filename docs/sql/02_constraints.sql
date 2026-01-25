-- 02_constraints.sql
-- Constraints (idempotente)

DO $$
BEGIN
    -- Representantes: UNIQUE codigointerno
    IF NOT EXISTS (SELECT 1 FROM pg_constraint WHERE conname = 'uq_representante_codigointerno') THEN
ALTER TABLE belgem.representantes
    ADD CONSTRAINT uq_representante_codigointerno UNIQUE (codigointerno);
END IF;

    -- Clientes: FK representante_id -> representantes.id_representante
    IF NOT EXISTS (SELECT 1 FROM pg_constraint WHERE conname = 'fk_cliente_representante') THEN
ALTER TABLE belgem.cliente
    ADD CONSTRAINT fk_cliente_representante
        FOREIGN KEY (representante_id)
            REFERENCES belgem.representantes(id_representante);
END IF;

    -- Clientes: UNIQUE nif (para ON CONFLICT)
    IF NOT EXISTS (SELECT 1 FROM pg_constraint WHERE conname = 'uq_cliente_nif') THEN
ALTER TABLE belgem.cliente
    ADD CONSTRAINT uq_cliente_nif UNIQUE (nif);
END IF;

    -- Divisas: UNIQUE code
    IF NOT EXISTS (SELECT 1 FROM pg_constraint WHERE conname = 'uq_divisa_code') THEN
ALTER TABLE belgem.divisas
    ADD CONSTRAINT uq_divisa_code UNIQUE (code);
END IF;
END $$;
