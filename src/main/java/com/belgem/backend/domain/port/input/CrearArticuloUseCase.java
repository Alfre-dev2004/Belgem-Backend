package com.belgem.backend.domain.port.input;

import com.belgem.backend.domain.model.Articulo;
/**
 * Caso de uso para crear un nuevo {@link Articulo}.
 */
public interface CrearArticuloUseCase {
    Articulo crear(Articulo articulo);
}
