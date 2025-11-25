package com.belgem.backend.domain.port.input;

import com.belgem.backend.domain.model.Articulo;

public interface ActualizarArticuloUseCase {
    Articulo actualizar(Long id, Articulo articulo);
}
