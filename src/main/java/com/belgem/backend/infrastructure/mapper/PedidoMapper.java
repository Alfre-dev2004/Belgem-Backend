package com.belgem.backend.infrastructure.mapper;


import com.belgem.backend.domain.model.Pedido;
import com.belgem.backend.infrastructure.adapter.output.persistence.jpa.PedidoJpaEntity;

public class PedidoMapper {

    public static Pedido toDomain(PedidoJpaEntity e) {
        return new Pedido(
                e.getId(),
                e.getClienteId(),
                e.getRepresentanteId(),
                e.getFecha(),
                e.getEstado(),
                e.getTotal(),
                e.getObservaciones()
        );
    }

    public static PedidoJpaEntity toEntity(Pedido p) {
        PedidoJpaEntity e = new PedidoJpaEntity();
        e.setId(p.getId());
        e.setClienteId(p.getClienteId());
        e.setRepresentanteId(p.getRepresentanteId());
        e.setFecha(p.getFecha());
        e.setEstado(p.getEstado());
        e.setTotal(p.getTotal());
        e.setObservaciones(p.getObservaciones());
        return e;
    }
}

