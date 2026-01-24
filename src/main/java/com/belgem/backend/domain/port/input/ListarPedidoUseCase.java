package com.belgem.backend.domain.port.input;

import com.belgem.backend.domain.model.Pedido;

import java.util.List;

public interface ListarPedidoUseCase {
    List<Pedido> findAll();
}
