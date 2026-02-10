CREATE TABLE IF NOT EXISTS belgem.articulos (
    id       BIGSERIAL PRIMARY KEY,
    cantidad INTEGER       NOT NULL,
    dto      NUMERIC(5,2),
    nombre   VARCHAR(150)  NOT NULL,
    precio   NUMERIC(10,2) NOT NULL
);