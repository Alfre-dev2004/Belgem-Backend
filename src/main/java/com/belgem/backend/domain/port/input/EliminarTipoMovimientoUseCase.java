package com.belgem.backend.domain.port.input;

/**
 * Puerto de entrada: eliminar un TipoMovimiento por id.
 */
public interface EliminarTipoMovimientoUseCase {
    void eliminar(Long id);
}