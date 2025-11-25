package com.belgem.backend.domain.exception;
/**
 * Excepción de dominio que indica que no se ha encontrado
 * un artículo con el identificador especificado.
 */
public class ArticuloNoEncontradoException extends RuntimeException {

    public ArticuloNoEncontradoException(Long id) {
        super("No se encontró el artículo con id " + id);
    }
}