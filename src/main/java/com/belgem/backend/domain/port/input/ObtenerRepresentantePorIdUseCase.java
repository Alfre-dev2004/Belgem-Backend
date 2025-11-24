package com.belgem.backend.domain.port.input;

import com.belgem.backend.domain.model.Representante;

public interface ObtenerRepresentantePorIdUseCase {

    Representante obtenerRepresentantePorId(Long id);
}
