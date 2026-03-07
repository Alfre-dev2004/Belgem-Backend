CREATE TABLE stock_almacen (
                               id BIGSERIAL PRIMARY KEY,
                               articulo_id BIGINT NOT NULL,
                               almacen_id BIGINT NOT NULL,
                               stock_actual INTEGER NOT NULL DEFAULT 0,

                               CONSTRAINT fk_articulo
                                   FOREIGN KEY (articulo_id) REFERENCES articulo(id),

                               CONSTRAINT fk_almacen
                                   FOREIGN KEY (almacen_id) REFERENCES almacen(id),

                               CONSTRAINT unique_articulo_almacen
                                   UNIQUE (articulo_id, almacen_id)
);
