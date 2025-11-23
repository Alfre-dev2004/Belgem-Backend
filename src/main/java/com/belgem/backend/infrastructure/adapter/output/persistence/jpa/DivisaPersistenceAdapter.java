package com.belgem.backend.infrastructure.adapter.output.persistence.jpa;

import com.belgem.backend.domain.model.Divisa;
import com.belgem.backend.domain.port.output.DivisaRepositoryPort;
import com.belgem.backend.infrastructure.mapper.DivisaMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


/*“adapter” encargado de mover datos entre dominio ↔ BD.*/
@Repository
public class DivisaPersistenceAdapter implements DivisaRepositoryPort {

    private final DivisaJpaRepository jpaRepository;
    private final DivisaMapper mapper;

    public DivisaPersistenceAdapter(DivisaJpaRepository jpaRepository, DivisaMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public Divisa save(Divisa divisa) {
        DivisaJpaEntity entity = mapper.toEntity(divisa);
        DivisaJpaEntity saved = jpaRepository.save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<Divisa> findById(Long id) {
        return jpaRepository.findById(id)
                .map(mapper::toDomain);
    }

    @Override
    public List<Divisa> findAll() {
        return jpaRepository.findAll().stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }

    @Override
    public boolean existsByCode(String code) {
        return jpaRepository.existsByCode(code);
    }
}