package com.belgem.backend.infrastructure.mapper;

import com.belgem.backend.domain.model.PedidoDetalle;
import com.belgem.backend.infrastructure.adapter.output.persistence.jpa.PedidoDetalleJpaEntity;
import org.springframework.stereotype.Component;

@Component
public class PedidoDetalleMapper {

    public PedidoDetalle toDomain(PedidoDetalleJpaEntity e) {
        return new PedidoDetalle(
                e.getId(),
                e.getPedidoId(),
                e.getArticuloId(),
                e.getCantidad(),
                e.getPrecioUnitario(),
                e.getSubtotal()
        );
    }

    public PedidoDetalleJpaEntity toJpaEntity(PedidoDetalle d) {
        PedidoDetalleJpaEntity e = new PedidoDetalleJpaEntity();
        e.setId(d.getId());
        e.setPedidoId(d.getPedidoId());
        e.setArticuloId(d.getArticuloId());
        e.setCantidad(d.getCantidad());
        e.setPrecioUnitario(d.getPrecioUnitario());
        e.setSubtotal(d.getSubtotal());
        return e;
    }
}
