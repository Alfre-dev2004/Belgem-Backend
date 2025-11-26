package com.belgem.backend.domain.port.input;

/**
 * Puerto de entrada para eliminar un Representante existente.
 *
 * Permite eliminar un representante del sistema
 * usando su identificador único.
 */
public interface EliminarRepresentanteUseCase {

    void eliminar(Long id);
}
