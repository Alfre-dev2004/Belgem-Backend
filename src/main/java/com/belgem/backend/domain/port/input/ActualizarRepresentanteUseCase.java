package com.belgem.backend.domain.port.input;

import com.belgem.backend.domain.model.Representante;

public interface ActualizarRepresentanteUseCase {
    Representante actualizar(Long id, Representante nuevoRepresentante);
}
