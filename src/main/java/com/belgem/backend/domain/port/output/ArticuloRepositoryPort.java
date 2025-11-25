package com.belgem.backend.domain.port.output;

import com.belgem.backend.domain.model.Articulo;

import java.util.List;
import java.util.Optional;

public interface  ArticuloRepositoryPort {
    Articulo save(Articulo articulo);

    Optional<Articulo> findById(Long id);

    List<Articulo> findAll();

    boolean existsById(Long id);

    void deleteById(Long id);

    List<Articulo> findByNombreContainingIgnoreCase(String nombre);
}
