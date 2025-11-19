package com.belgem.backend.infrastructure.adapter.output.persistence.jpa;

// Importa la JPA Entity, que es la que Spring Data maneja
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticuloJpaRepository extends JpaRepository<ArticuloJpaEntity, Long> { // CORRECTO: Usa JpaEntity
}