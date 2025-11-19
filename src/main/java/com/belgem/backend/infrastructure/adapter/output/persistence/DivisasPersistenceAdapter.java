package com.belgem.backend.infrastructure.adapter.output.persistence;

import com.belgem.backend.domain.model.Divisas;
import com.belgem.backend.domain.port.output.DivisasRepositoryPort;
import com.belgem.backend.infrastructure.adapter.out.persistence.jpa.DivisasJpaEntity;
import com.belgem.backend.infrastructure.adapter.out.persistence.jpa.DivisasJpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class DivisasPersistenceAdapter implements DivisasRepositoryPort {

    private final DivisasJpaRepository jpaRepository;

    public DivisasPersistenceAdapter(DivisasJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    // --- MAPPERS ESTATÍCOS ---
    private static DivisasJpaEntity toJpaEntity(Divisas domain) {
        DivisasJpaEntity jpa = new DivisasJpaEntity();
        jpa.setId(domain.getDivisaId());
        jpa.setCode(domain.getCode());
        jpa.setName(domain.getName());
        return jpa;
    }

    private static Divisas toDomainEntity(DivisasJpaEntity jpa) {
        Divisas domain = new Divisas();
        domain.setDivisaId(jpa.getId());
        domain.setCode(jpa.getCode());
        domain.setName(jpa.getName());
        return domain;
    }
    // --- IMPLEMENTACIÓN DE PUERTO ---

    @Override
    public Divisas save(Divisas divisa) {
        DivisasJpaEntity jpaEntity = toJpaEntity(divisa);
        DivisasJpaEntity saved = jpaRepository.save(jpaEntity);
        return toDomainEntity(saved);
    }

    @Override
    public Optional<Divisas> findById(Long divisaId) {
        return jpaRepository.findById(divisaId)
                .map(DivisasPersistenceAdapter::toDomainEntity);
    }

    @Override
    public boolean existsById(Long divisaId) {
        return jpaRepository.existsById(divisaId);
    }

    @Override
    public List<Divisas> findAll() {
        return jpaRepository.findAll().stream()
                .map(DivisasPersistenceAdapter::toDomainEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long divisaId) {
        jpaRepository.deleteById(divisaId);
    }

    @Override
    public boolean existsByCode(String code) {
        return jpaRepository.existsByCode(code);
    }

    @Override
    public Optional<Divisas> findByCode(String code) {
        return jpaRepository.findByCode(code)
                .map(DivisasPersistenceAdapter::toDomainEntity);
    }

    @Override
    public void deleteByCode(String code) {
        jpaRepository.deleteByCode(code);
    }
}