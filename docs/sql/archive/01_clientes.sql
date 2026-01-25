
-- Tabla del módulo Clientes

CREATE TABLE IF NOT EXISTS belgem.cliente (
    id BIGSERIAL PRIMARY KEY,
    nombre VARCHAR(150) NOT NULL,
    nif VARCHAR(20) NOT NULL,
    direccion VARCHAR(255),
    ciudad VARCHAR(100),
    codigoPostal VARCHAR(20),
    telefono VARCHAR(50),
    email VARCHAR(150),
    tipoCliente VARCHAR(50),
    zona VARCHAR(100),
    representante_id BIGINT,
    observaciones TEXT
);
