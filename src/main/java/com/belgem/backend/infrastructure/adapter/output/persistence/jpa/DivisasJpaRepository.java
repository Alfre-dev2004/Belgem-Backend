package com.belgem.backend.infrastructure.adapter.output.persistence.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

// EXTENSIÓN Y MÉTODOS AHORA USAN LA JPA ENTITY
public interface DivisasJpaRepository extends JpaRepository<DivisasJpaEntity, Long> {
    boolean existsByCode(String code);
    Optional<DivisasJpaEntity> findByCode(String code); // CORREGIDO: Devuelve JpaEntity
    void deleteByCode(String code);
}