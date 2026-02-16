package com.belgem.backend.infrastructure.adapter.output.persistence.jpa;

import com.belgem.backend.domain.model.StockAlmacen;
import com.belgem.backend.domain.port.output.StockAlmacenRepositoryPort;
import com.belgem.backend.infrastructure.adapter.output.persistence.jpa.StockAlmacenJpaRepository;
import com.belgem.backend.infrastructure.mapper.StockAlmacenMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class StockAlmacenJpaAdapter implements StockAlmacenRepositoryPort {

    private final StockAlmacenJpaRepository jpaRepository;
    private final StockAlmacenMapper mapper;

    public StockAlmacenJpaAdapter(StockAlmacenJpaRepository jpaRepository, StockAlmacenMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public StockAlmacen save(StockAlmacen stockAlmacen) {
        var saved = jpaRepository.save(mapper.toEntity(stockAlmacen));
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<StockAlmacen> findById(Long id) {
        return jpaRepository.findById(id).map(mapper::toDomain);
    }

    @Override
    public Optional<StockAlmacen> findByArticuloIdAndAlmacenId(Long articuloId, Long almacenId) {
        return jpaRepository.findByArticuloIdAndAlmacenId(articuloId, almacenId).map(mapper::toDomain);
    }

    @Override
    public List<StockAlmacen> findAllByArticuloId(Long articuloId) {
        return jpaRepository.findAllByArticuloId(articuloId).stream().map(mapper::toDomain).toList();
    }

    @Override
    public List<StockAlmacen> findAllByAlmacenId(Long almacenId) {
        return jpaRepository.findAllByAlmacenId(almacenId).stream().map(mapper::toDomain).toList();
    }

    @Override
    public List<StockAlmacen> findAll() {
        return jpaRepository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }
}
