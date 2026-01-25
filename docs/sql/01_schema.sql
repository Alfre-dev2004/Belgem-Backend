-- 01_schema.sql
-- Estructura base GLOBAL

CREATE SCHEMA IF NOT EXISTS belgem;

-- Representantes
CREATE TABLE IF NOT EXISTS belgem.representantes (
                                                     id_representante BIGSERIAL PRIMARY KEY,
                                                     nombre           VARCHAR(100) NOT NULL,
    telefono         VARCHAR(50)  NOT NULL,
    email            VARCHAR(150),
    zona             VARCHAR(100) NOT NULL,
    codigointerno    VARCHAR(50)  NOT NULL,
    comision         NUMERIC(10,2)
    );

-- Clientes
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

-- Divisas
CREATE TABLE IF NOT EXISTS belgem.divisas (
                                              id   BIGSERIAL PRIMARY KEY,
                                              code VARCHAR(10)  NOT NULL,
    name VARCHAR(100) NOT NULL
    );
