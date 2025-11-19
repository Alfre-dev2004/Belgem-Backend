package com.belgem.backend.domain.port.output;

import com.belgem.backend.domain.model.Articulo;
import java.util.List;
import java.util.Optional;

public interface ArticuloRepositoryPort {
    Articulo save(Articulo articulo);
    Optional<Articulo> findById(Long articuloId);
    boolean existsById(Long articuloId);
    List<Articulo> findAll();
    void deleteById(Long articuloId);
}