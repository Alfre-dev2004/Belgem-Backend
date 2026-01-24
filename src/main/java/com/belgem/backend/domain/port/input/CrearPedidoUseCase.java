package com.belgem.backend.domain.port.input;

import com.belgem.backend.domain.model.Pedido;

public interface CrearPedidoUseCase {
    Pedido create(Pedido pedido);
}
