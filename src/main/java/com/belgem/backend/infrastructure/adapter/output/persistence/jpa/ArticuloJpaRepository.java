package com.belgem.backend.infrastructure.adapter.output.persistence.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
/**
 * Repositorio JPA para la entidad {@link ArticuloJpaEntity}.
 * <p>
 * Solo debe ser usado desde la capa de infraestructura,
 * nunca directamente desde la capa de aplicación o dominio.
 * </p>
 */
public interface ArticuloJpaRepository extends JpaRepository<ArticuloJpaEntity, Long> {
    List<ArticuloJpaEntity> findByNombreContainingIgnoreCase(String nombre);

    boolean existsByNombre(String nombre);

}
