package com.belgem.backend.infrastructure.adapter.output.persistence.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface PedidoDetalleJpaRepository extends JpaRepository<PedidoDetalleJpaEntity, Long> {

    List<PedidoDetalleJpaEntity> findByPedidoId(Long pedidoId);

    @Query("select coalesce(sum(d.subtotal), 0) from PedidoDetalleJpaEntity d where d.pedidoId = :pedidoId")
    BigDecimal sumSubtotalByPedidoId(@Param("pedidoId") Long pedidoId);
}
