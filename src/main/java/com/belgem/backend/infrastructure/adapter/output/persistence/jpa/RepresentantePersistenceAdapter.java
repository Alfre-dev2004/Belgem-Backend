package com.belgem.backend.infrastructure.adapter.output.persistence.jpa;

import com.belgem.backend.domain.model.Representante;
import com.belgem.backend.domain.port.output.RepresentanteRepositoryPort;
import com.belgem.backend.infrastructure.mapper.RepresentanteMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * Adaptador de persistencia para Representantes.
 * Implementa el puerto de salida del dominio y delega en
 * el repositorio JPA para realizar operaciones CRUD y consultas adicionales.
 */
@Component
public class RepresentantePersistenceAdapter implements RepresentanteRepositoryPort {

    private final RepresentanteJpaRepository repository;
    private final RepresentanteMapper mapper;

    public RepresentantePersistenceAdapter(RepresentanteJpaRepository repository, RepresentanteMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Representante save(Representante representante) {
        RepresentanteJpaEntity entity = mapper.toJpa(representante);
        RepresentanteJpaEntity saved = repository.save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<Representante> findById(Long id) {
        return repository.findById(id).map(mapper::toDomain);
    }

    @Override
    public List<Representante> findAll() {
        return repository.findAll().stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public boolean existsById(Long id) {
        return repository.existsById(id);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public boolean existsByInternalCode(String internalCode) {
        return repository.existsByInternalCode(internalCode);
    }
    public boolean existsByEmail(String email) {
        return repository.existsByEmail(email); // Delegamos a JPA

    }
    }
