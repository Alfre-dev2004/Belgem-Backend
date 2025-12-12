package com.belgem.backend.infrastructure.adapter.output.persistence.jpa;
/**
 * Adaptador de infraestructura que implementa el puerto de salida
 * AlmacenRepositoryPort usando JPA.
 *
 * Responsable de:
 *  - Convertir entre modelo de dominio ↔ JPA entity.
 *  - Aislar la tecnología de persistencia del resto del sistema.
 *
 * Esta clase es el puente entre la arquitectura hexagonal y la BD real.
 */

import com.belgem.backend.domain.model.Almacen;
import com.belgem.backend.domain.port.output.AlmacenRepositoryPort;
import com.belgem.backend.infrastructure.mapper.AlmacenMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AlmacenPersistenceAdapter implements AlmacenRepositoryPort {
    private final AlmacenJpaRepository jpaRepository;
    private final AlmacenMapper mapper;

    public AlmacenPersistenceAdapter (AlmacenJpaRepository jpaRepository, AlmacenMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public Almacen save(Almacen almacen) {
        AlmacenJpaEntity entity = mapper.toEntity(almacen);
        AlmacenJpaEntity saved = jpaRepository.save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<Almacen> findById(Long id){
        return jpaRepository.findById(id)
                .map(mapper::toDomain);
    }

    @Override
    public List<Almacen> findAll() {
        return jpaRepository.findAll()
                .stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public void deleteById(Long id){
        jpaRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return jpaRepository.existsById(id);
    }

}

