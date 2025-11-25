package com.belgem.backend.domain.port.output;

import com.belgem.backend.domain.model.Articulo;

import java.util.List;
import java.util.Optional;
/**
 * Puerto de salida para operaciones de persistencia relacionadas con {@link Articulo}.
 * Esta interfaz no conoce nada de JPA ni de la infraestructura;
 * simplemente define lo que la aplicación necesita del repositorio.
 *
 */
public interface ArticuloRepositoryPort {
    Articulo save(Articulo articulo);

    Optional<Articulo> findById(Long id);

    List<Articulo> findAll();

    boolean existsById(Long id);

    void deleteById(Long id);

    List<Articulo> findByNombre(String nombre);

    boolean existsByNombre(String nombre);

}
