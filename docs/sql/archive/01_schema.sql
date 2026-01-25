CREATE SCHEMA IF NOT EXISTS belgem;

CREATE TABLE IF NOT EXISTS belgem.representantes (
                                                     id_representante BIGSERIAL PRIMARY KEY,
                                                     nombre           VARCHAR(100) NOT NULL,
    telefono         VARCHAR(50)  NOT NULL,
    email            VARCHAR(150),
    zona             VARCHAR(100) NOT NULL,
    codigointerno    VARCHAR(50)  NOT NULL,
    comision         NUMERIC(10,2)
    );
