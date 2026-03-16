package com.belgem.backend.infrastructure.adapter.output.persistence.jpa;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovimientoStockJpaRepository extends JpaRepository<MovimientoStockJpaEntity, Long> {

    List<MovimientoStockJpaEntity> findAllByArticuloId(Long articuloId);

    List<MovimientoStockJpaEntity> findAllByAlmacenId(Long almacenId);
}