package com.belgem.backend.infrastructure.adapter.output.persistence.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorio Spring Data JPA para {@link TipoMovimientoJpaEntity}
 */

public interface TipoMovimientoJpaRepository extends JpaRepository<TipoMovimientoJpaEntity, Long> {

    /**
     * Indica si existe un tipo de movimiento con ese nombre.
     *
     * @param nombre nombre a comprobar
     * @return true si existe
     */
    boolean existsByNombre(String nombre);

}
