-- ====================================================================
-- 01_schema.sql
-- Definición de tablas base del proyecto Belgem (sin constraints)
-- ====================================================================

-- ==========================
-- Tabla DIVISAS
-- ==========================
CREATE TABLE IF NOT EXISTS belgem.divisas (
                                              id          BIGSERIAL PRIMARY KEY,
                                              code        VARCHAR(10)  NOT NULL,
    name        VARCHAR(100) NOT NULL
    );

-- ==========================
-- Tabla REPRESENTANTES
-- ==========================
CREATE TABLE IF NOT EXISTS belgem.representantes (
                                                     id               BIGSERIAL PRIMARY KEY,
                                                     nombre           VARCHAR(100) NOT NULL,
    telefono         VARCHAR(50)  NOT NULL,
    email            VARCHAR(150),
    zona             VARCHAR(100) NOT NULL,
    codigointerno    VARCHAR(50)  NOT NULL,
    comision         NUMERIC(10,2)
    );

-- ==========================
-- Tabla CLIENTES
-- ==========================
CREATE TABLE IF NOT EXISTS belgem.cliente (
                                              id              BIGSERIAL PRIMARY KEY,
                                              nombre          VARCHAR(150) NOT NULL,
    nif             VARCHAR(20)  NOT NULL,
    direccion       VARCHAR(255),
    ciudad          VARCHAR(100),
    codigoPostal    VARCHAR(20),
    telefono        VARCHAR(50),
    email           VARCHAR(150),
    tipoCliente     VARCHAR(50),
    zona            VARCHAR(100),
    representante_id BIGINT,
    observaciones   TEXT
    );

-- ==========================
-- Tabla ARTICULOS
-- ==========================
CREATE TABLE IF NOT EXISTS belgem.articulos (
                                                id        BIGSERIAL PRIMARY KEY,
                                                nombre    VARCHAR(150) NOT NULL,
    cantidad  INTEGER NOT NULL,
    dto       NUMERIC(5,2),
    precio    NUMERIC(10,2) NOT NULL
    );

-- ==========================
-- Tabla ALMACENES
-- ==========================
CREATE TABLE IF NOT EXISTS belgem.almacenes (
                                                id          BIGSERIAL PRIMARY KEY,
                                                nombre      VARCHAR(150) NOT NULL,
    direccion   VARCHAR(255),
    telefono    VARCHAR(50),
    responsable VARCHAR(150),
    activo      BOOLEAN DEFAULT TRUE
    );
