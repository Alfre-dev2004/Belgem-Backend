CREATE TABLE IF NOT EXISTS belgem.articulos (
    id          BIGSERIAL PRIMARY KEY,
    nombre      VARCHAR(150) NOT NULL,
    situacion   VARCHAR(20)  NOT NULL,
    pvp_minimo  NUMERIC(10,2),
    peso_kg     NUMERIC(10,3),
    alto_cm     NUMERIC(10,2),
    ancho_cm    NUMERIC(10,2),
    largo_cm    NUMERIC(10,2),
    vendible    BOOLEAN      NOT NULL
);