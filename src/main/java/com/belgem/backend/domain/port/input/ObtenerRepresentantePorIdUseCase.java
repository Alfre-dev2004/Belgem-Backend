package com.belgem.backend.domain.port.input;

import com.belgem.backend.domain.model.Representante;

/**
 * Puerto de entrada para obtener un Representante por su ID.
 *
 * Permite recuperar la información de un representante
 * existente en el sistema usando su identificador único.
 */
public interface ObtenerRepresentantePorIdUseCase {

    Representante obtener(Long id);
}
