package com.belgem.backend.domain.port.input;

import com.belgem.backend.domain.model.Articulo;

import java.util.List;
/**
 * Caso de uso para listar todos los artículos.
 */
public interface ListarArticulosUseCase {
    List<Articulo> listar();
}
