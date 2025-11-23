package com.belgem.backend.infrastructure.adapter.output.persistence.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorio JPA para la entidad ClienteJpaEntity.
 * Extiende JpaRepository para obtener operaciones CRUD automáticas.
 */
public interface ClienteJpaRepository extends JpaRepository<ClienteJpaEntity, Long> {
}
