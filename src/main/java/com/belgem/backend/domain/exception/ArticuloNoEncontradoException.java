package com.belgem.backend.domain.exception;

public class ArticuloNoEncontradoException extends RuntimeException {

    public ArticuloNoEncontradoException(Long id) {
        super("No se encontró el artículo con id " + id);
    }
}