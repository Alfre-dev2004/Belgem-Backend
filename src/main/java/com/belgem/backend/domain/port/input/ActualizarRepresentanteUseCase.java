package com.belgem.backend.domain.port.input;

import com.belgem.backend.domain.model.Representante;

/**
 * Puerto de entrada para actualizar un Representante.
 *
 * Permite actualizar los datos de un representante existente
 * identificado por su ID con la información proporcionada
 * en un objeto Representante.
 */
public interface ActualizarRepresentanteUseCase {
    Representante actualizar(Long id, Representante nuevoRepresentante);
}
