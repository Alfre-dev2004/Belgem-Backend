package com.belgem.backend.domain.port.input;

import com.belgem.backend.domain.model.Pedido;

public interface ActualizarPedidoUseCase {
    Pedido updateStatus(Long pedidoId, String newStatus);
}
