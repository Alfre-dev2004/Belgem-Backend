package com.belgem.backend.infrastructure.adapter.output.persistence.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio JPA para la entidad ClienteJpaEntity.
 */
@Repository
public interface ClienteJpaRepository extends JpaRepository<ClienteJpaEntity, Long> { // CORRECTO: Usa JpaEntity
}