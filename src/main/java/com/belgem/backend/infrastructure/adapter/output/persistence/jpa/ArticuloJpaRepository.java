package com.belgem.backend.infrastructure.adapter.output.persistence.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticuloJpaRepository extends JpaRepository<ArticuloJpaEntity, Long> {
    List<ArticuloJpaEntity> findByNombreContainingIgnoreCase(String nombre);

}
