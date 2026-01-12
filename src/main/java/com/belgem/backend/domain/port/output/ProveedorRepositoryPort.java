package com.belgem.backend.domain.port.output;

import com.belgem.backend.domain.model.Proveedor;

import java.util.List;
import java.util.Optional;

/**
 * Puerto de salida para operaciones de persistencia relacionadas con {@link Proveedor}.
 * Esta interfaz no conoce nada de JPA ni de la infraestructura;
 * simplemente define lo que la aplicación necesita del repositorio.
 *
 */
public interface ProveedorRepositoryPort {

    Proveedor save(Proveedor proveedor);

    Optional<Proveedor> findById(Long id);

    List<Proveedor> findAll();

    boolean existsById(Long id);

    void deleteById(Long id);

    List<Proveedor> findByNombre(String nombre);

    boolean existsByNombre(String nombre);

    boolean existsByCif(String cif);
}
