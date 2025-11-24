package com.belgem.backend.domain.port.output;

import com.belgem.backend.domain.model.Representante;
import java.util.List;
import java.util.Optional;

/**
 * Puerto de salida para la persistencia de Representantes.
 *
 * Define las operaciones necesarias para guardar, buscar,
 * listar, comprobar existencia y eliminar representantes
 * en la capa de infraestructura.
 */
public interface RepresentanteRepositoryPort {

    Representante save(Representante representante);

    Optional<Representante> findById(Long id);

    List<Representante> findAll();

    boolean existsById(Long id);

    void deleteById(Long id);

    boolean existsByInternalCode(String internalCode);
}
