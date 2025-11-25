package com.belgem.backend.domain.port.input;

import com.belgem.backend.domain.model.Representante;

/**
 * Puerto de entrada para crear un nuevo Representante.
 *
 * Permite registrar un representante en el sistema usando
 * la información proporcionada en un objeto Representante.
 */
public interface CrearRepresentanteUseCase {
    Representante crear(Representante representante);
}
