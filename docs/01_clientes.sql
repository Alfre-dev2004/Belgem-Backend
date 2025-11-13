SET search_path TO v1, public;

CREATE TABLE IF NOT EXISTS cliente (

    idCliente BIGSERIAL PRIMARY KEY,
    nombre VARCHAR(120) NOT NULL,
    nif VARCHAR(20),
    direccion VARCHAR(200),
    ciudad VARCHAR(120),
    codigoPostal VARCHAR(15),
    telefono VARCHAR(25),
    email VARCHAR(160),
    tipoCliente VARCHAR(60),
    zona VARCHAR(80),
    representante VARCHAR(120),
    observaciones TEXT

);
