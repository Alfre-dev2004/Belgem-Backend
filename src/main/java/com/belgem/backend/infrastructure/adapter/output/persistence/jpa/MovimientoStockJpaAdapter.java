package com.belgem.backend.infrastructure.adapter.output.persistence.jpa;

import com.belgem.backend.domain.model.MovimientoStock;
import com.belgem.backend.domain.port.output.MovimientoStockRepositoryPort;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MovimientoStockJpaAdapter implements MovimientoStockRepositoryPort {

    private final MovimientoStockJpaRepository jpaRepository;
    private final MovimientoStockJpaMapper mapper;

    public MovimientoStockJpaAdapter(MovimientoStockJpaRepository jpaRepository,
                                     MovimientoStockJpaMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public MovimientoStock save(MovimientoStock movimientoStock) {
        MovimientoStockJpaEntity entity = mapper.toEntity(movimientoStock);
        MovimientoStockJpaEntity saved = jpaRepository.save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<MovimientoStock> findById(Long id) {
        return jpaRepository.findById(id).map(mapper::toDomain);
    }

    @Override
    public List<MovimientoStock> findAll() {
        return jpaRepository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public List<MovimientoStock> findAllByArticuloId(Long articuloId) {
        return jpaRepository.findAllByArticuloId(articuloId).stream().map(mapper::toDomain).toList();
    }

    @Override
    public List<MovimientoStock> findAllByAlmacenId(Long almacenId) {
        return jpaRepository.findAllByAlmacenId(almacenId).stream().map(mapper::toDomain).toList();
    }
}