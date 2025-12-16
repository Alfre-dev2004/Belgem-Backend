package com.belgem.backend.domain.exception;
/**
 * Excepción de dominio que indica que no se ha encontrado
 * un proveedor con el identificador especificado.
 */
public class ProveedorNoEncontradoException extends RuntimeException {

    public ProveedorNoEncontradoException(Long id) {
        super("No se encontró el proveedor con id " + id);
    }
}