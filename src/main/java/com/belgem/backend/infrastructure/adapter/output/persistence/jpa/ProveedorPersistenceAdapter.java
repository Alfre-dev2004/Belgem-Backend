package com.belgem.backend.infrastructure.adapter.output.persistence.jpa;

import com.belgem.backend.domain.model.Proveedor;
import com.belgem.backend.domain.port.output.ProveedorRepositoryPort;
import com.belgem.backend.infrastructure.mapper.ProveedorMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Adaptador de persistencia que implementa el puerto de salida
 * {@link ProveedorRepositoryPort} usando JPA/Hibernate.
 * <p>
 * Aquí se traduce el modelo de dominio a entidades JPA y viceversa.
 * </p>
 */
@Repository
public class ProveedorPersistenceAdapter implements ProveedorRepositoryPort {

    private final ProveedorJpaRepository jpaRepository;
    private final ProveedorMapper mapper;

    public ProveedorPersistenceAdapter(ProveedorJpaRepository jpaRepository,
                                       ProveedorMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public Proveedor save(Proveedor proveedor) {
        ProveedorJpaEntity entity = mapper.toEntity(proveedor);
        ProveedorJpaEntity saved = jpaRepository.save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<Proveedor> findById(Long id) {
        return jpaRepository.findById(id)
                .map(mapper::toDomain);
    }

    @Override
    public List<Proveedor> findAll() {
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
    public List<Proveedor> findByNombre(String nombre) {
        return jpaRepository.findByNombreContainingIgnoreCase(nombre)
                .stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public boolean existsByNombre(String nombre) {
        return jpaRepository.existsByNombre(nombre);
    }

    @Override
    public boolean existsByCif(String cif) {
        return jpaRepository.existsByCif(cif);
    }
}
