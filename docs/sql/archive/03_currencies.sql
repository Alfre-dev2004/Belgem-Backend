-- ============================================
-- Tabla: belgem.currencies
-- Origen: Supabase (generada automáticamente)
-- ============================================

CREATE TABLE belgem.currencies (
                                   id   SERIAL NOT NULL,
                                   code TEXT   NOT NULL,
                                   name TEXT   NOT NULL,

                                   CONSTRAINT currencies_pkey PRIMARY KEY (id),

    -- Código único por divisa
                                   CONSTRAINT currencies_code_key UNIQUE (code),

    -- Longitud permitida (3 a 6 caracteres)
                                   CONSTRAINT currencies_code_check CHECK (
                                       LENGTH(code) >= 3 AND LENGTH(code) <= 6
                                       )
) TABLESPACE pg_default;
