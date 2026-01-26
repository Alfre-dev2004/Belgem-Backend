ALTER TABLE belgem.articulos
    ADD CONSTRAINT chk_articulos_cantidad
        CHECK (cantidad >= 0),

    ADD CONSTRAINT chk_articulos_dto
        CHECK (dto IS NULL OR (dto >= 0 AND dto <= 100)),

    ADD CONSTRAINT chk_articulos_precio
        CHECK (precio > 0);