package com.belgem.backend.domain.port.input;

import com.belgem.backend.domain.model.PedidoDetalle;

import java.util.List;

public interface ListarPedidoDetalleUseCase {
    List<PedidoDetalle> listarPorPedidoId(Long pedidoid);
}
