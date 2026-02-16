package com.belgem.backend.infrastructure.adapter.output.persistence.jpa;

import com.belgem.backend.infrastructure.adapter.output.persistence.jpa.StockAlmacenJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StockAlmacenJpaRepository extends JpaRepository<StockAlmacenJpaEntity, Long> {

    Optional<StockAlmacenJpaEntity> findByArticuloIdAndAlmacenId(Long articuloId, Long almacenId);

    List<StockAlmacenJpaEntity> findAllByArticuloId(Long articuloId);

    List<StockAlmacenJpaEntity> findAllByAlmacenId(Long almacenId);
}
