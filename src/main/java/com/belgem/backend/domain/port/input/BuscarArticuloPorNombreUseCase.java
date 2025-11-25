package com.belgem.backend.domain.port.input;

import com.belgem.backend.domain.model.Articulo;

import java.util.List;
/**
 * Caso de uso para buscar artículos por nombre.
 */
public interface BuscarArticuloPorNombreUseCase {
    List<Articulo> buscarPorNombre(String nombre);
}
