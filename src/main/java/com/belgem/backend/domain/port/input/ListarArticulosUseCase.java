package com.belgem.backend.domain.port.input;

import com.belgem.backend.domain.model.Articulo;

import java.util.List;

public interface ListarArticulosUseCase {
    List<Articulo> listar();
}
