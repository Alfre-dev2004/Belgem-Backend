package com.belgem.backend.domain.port.input;

import com.belgem.backend.domain.model.Articulo;

public interface CrearArticuloUseCase {
    Articulo crear(Articulo articulo);
}
