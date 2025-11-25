package com.belgem.backend.domain.port.input;

import com.belgem.backend.domain.model.Articulo;

import java.util.List;

public interface BuscarArticuloPorNombreUseCase {
    List<Articulo> buscarPorNombre(String nombre);
}
