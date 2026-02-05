ALTER TABLE belgem.articulos
    ADD CONSTRAINT chk_articulos_situacion
        CHECK (situacion IN ('ACTIVO', 'INACTIVO')),

    ADD CONSTRAINT chk_articulos_pvp_minimo
        CHECK (pvp_minimo IS NULL OR pvp_minimo >= 0),

    ADD CONSTRAINT chk_articulos_peso_kg
        CHECK (peso_kg IS NULL OR peso_kg >= 0),

    ADD CONSTRAINT chk_articulos_alto_cm
        CHECK (alto_cm IS NULL OR alto_cm >= 0),

    ADD CONSTRAINT chk_articulos_ancho_cm
        CHECK (ancho_cm IS NULL OR ancho_cm >= 0),

    ADD CONSTRAINT chk_articulos_largo_cm
        CHECK (largo_cm IS NULL OR largo_cm >= 0);