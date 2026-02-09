package com.belgem.backend.infrastructure.adapter.output.persistence.jpa;


import com.belgem.backend.domain.model.PedidoDetalle;
import com.belgem.backend.domain.port.output.PedidoDetalleRepositoryPort;
import com.belgem.backend.infrastructure.mapper.PedidoDetalleMapper;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class PedidoDetallePersistenceAdapter implements PedidoDetalleRepositoryPort {

    private final PedidoDetalleJpaRepository repository;
    private final PedidoDetalleMapper mapper;

    public PedidoDetallePersistenceAdapter(PedidoDetalleJpaRepository repository, PedidoDetalleMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public PedidoDetalle save(PedidoDetalle detalle) {
        PedidoDetalleJpaEntity saved = repository.save(mapper.toJpaEntity(detalle));
        return mapper.toDomain(saved);
    }

    @Override
    public List<PedidoDetalle> findByPedidoId(Long pedidoId) {
        return repository.findByPedidoId(pedidoId).stream().map(mapper::toDomain).toList();
    }

    @Override
    public BigDecimal sumSubtotalByPedidoId(Long pedidoId) {
        return repository.sumSubtotalByPedidoId(pedidoId);
    }
}
