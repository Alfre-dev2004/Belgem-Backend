package com.belgem.backend.domain.port.output;

import com.belgem.backend.domain.model.PedidoDetalle;

import java.math.BigDecimal;
import java.util.List;

public interface PedidoDetalleRepositoryPort {

    PedidoDetalle save(PedidoDetalle detalle);

    List<PedidoDetalle> findByPedidoId(Long pedidoId);

    /**
     * Useful for recalculating Pedidototal later.
     */
    BigDecimal sumSubtotalByPedidoId(Long pedidoId);
}