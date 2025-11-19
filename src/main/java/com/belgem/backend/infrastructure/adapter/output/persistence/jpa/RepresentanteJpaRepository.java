package com.belgem.backend.infrastructure.adapter.output.persistence.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

// EXTENSIÓN Y MÉTODOS AHORA USAN LA JPA ENTITY
public interface RepresentanteJpaRepository extends JpaRepository<RepresentanteJpaEntity, Long> {

    Optional<RepresentanteJpaEntity> findByEmail(String email); // CORREGIDO: Devuelve JpaEntity
    boolean existsByEmail(String email);
}