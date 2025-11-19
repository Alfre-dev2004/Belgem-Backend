package com.belgem.backend.domain.port.in;

import com.belgem.backend.domain.model.Articulo;
import java.util.List;

public interface GestionarArticuloUseCase {
    List<Articulo> listar();
    Articulo guardar(Articulo articulo);
    void eliminar(Long articuloId);
    Articulo actualizar(Long articuloId, Articulo articuloActualizado);
}