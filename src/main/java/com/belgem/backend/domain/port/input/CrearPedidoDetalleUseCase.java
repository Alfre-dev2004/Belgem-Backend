package com.belgem.backend.domain.port.input;

import com.belgem.backend.domain.model.PedidoDetalle;

public interface CrearPedidoDetalleUseCase {
    PedidoDetalle create(PedidoDetalle detalle);
}