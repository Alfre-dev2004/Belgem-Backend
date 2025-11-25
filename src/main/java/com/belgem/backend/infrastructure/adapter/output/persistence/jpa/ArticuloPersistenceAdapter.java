package com.belgem.backend.infrastructure.adapter.output.persistence.jpa;

import com.belgem.backend.domain.model.Articulo;
import com.belgem.backend.domain.port.output.ArticuloRepositoryPort;
import com.belgem.backend.infrastructure.adapter.output.persistence.jpa.ArticuloJpaEntity;
import com.belgem.backend.infrastructure.adapter.output.persistence.jpa.ArticuloJpaRepository;
import com.belgem.backend.infrastructure.mapper.ArticuloMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Adaptador de persistencia que implementa el puerto de salida
 * {@link ArticuloRepositoryPort} usando JPA/Hibernate.
 * <p>
 * Aquí se traduce el modelo de dominio a entidades JPA y viceversa.
 * </p>
 */
@Repository
public class ArticuloPersistenceAdapter implements ArticuloRepositoryPort {

    private final ArticuloJpaRepository jpaRepository;
    private final ArticuloMapper mapper;

    public ArticuloPersistenceAdapter(ArticuloJpaRepository jpaRepository, ArticuloMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public Articulo save(Articulo articulo) {
        ArticuloJpaEntity entity = mapper.toEntity(articulo);
        ArticuloJpaEntity saved = jpaRepository.save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<Articulo> findById(Long id) {
        return jpaRepository.findById(id)
                .map(mapper::toDomain);
    }

    @Override
    public List<Articulo> findAll() {
        return jpaRepository.findAll()
                .stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public boolean existsById(Long id) {
        return jpaRepository.existsById(id);
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }

    @Override
    public List<Articulo> findByNombre(String nombre) {
        return jpaRepository.findByNombreContainingIgnoreCase(nombre)
                .stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public boolean existsByNombre(String nombre) {
        return jpaRepository.existsByNombre(nombre);
    }

}