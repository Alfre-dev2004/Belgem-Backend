package com.belgem.backend.infrastructure.adapter.output.persistence.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

/**
 * Repositorio JPA de la entidad Representante.
 * Permite operaciones CRUD automáticas sobre la tabla "representantes"
 * y consultas adicionales útiles para validaciones (como evitar duplicados).
 */
public interface RepresentanteJpaRepository extends JpaRepository<RepresentanteJpaEntity, Long> {


    /**
     * Comprueba si existe un representante con un código interno dado.
     *
     * @param internalCode el código interno a comprobar
     * @return true si existe, false si no
     */
    boolean existsByInternalCode(String internalCode);
}
