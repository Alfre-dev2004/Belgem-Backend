package com.belgem.backend.domain.port.input;

import com.belgem.backend.domain.model.Articulo;
/**
 * Caso de uso para actualizar un {@link Articulo} existente.
 */
public interface ActualizarArticuloUseCase {
    Articulo actualizar(Long id, Articulo articulo);
}
