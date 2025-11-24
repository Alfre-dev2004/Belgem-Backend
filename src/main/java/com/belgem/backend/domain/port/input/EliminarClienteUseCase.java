package com.belgem.backend.domain.port.input;

/**
 *  Caso de uso para ELIMINAR un cliente del sistema.
 *  Este puerto de entrada define la acción que la aplicación debe permitir:
 *  eliminar un cliente a partir de su ID.
 */
public interface EliminarClienteUseCase {
    void eliminarCliente(Long id);
}

