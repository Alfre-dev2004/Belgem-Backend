package com.belgem.backend.infrastructure.adapter.output.persistence.jpa;
/**
 * Repositorio JPA para la entidad AlmacenJpaEntity.
 *
 * Extiende JpaRepository para proporcionar operaciones CRUD bases.
 * Su uso queda encapsulado dentro del Adapter.
 */

import org.springframework.data.jpa.repository.JpaRepository;

public interface AlmacenJpaRepository extends JpaRepository<AlmacenJpaEntity,Long> {
}
