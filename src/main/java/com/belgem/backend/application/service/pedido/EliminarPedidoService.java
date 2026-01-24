package com.belgem.backend.application.service.pedido;

import com.belgem.backend.domain.port.input.EliminarPedidoUseCase;
import com.belgem.backend.domain.port.output.PedidoRepositoryPort;
import org.springframework.stereotype.Service;

@Service
public class EliminarPedidoService implements EliminarPedidoUseCase {

    private final PedidoRepositoryPort pedidoRepository;

    public EliminarPedidoService(PedidoRepositoryPort pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @Override
    public void deleteById(Long pedidoId) {
        if (pedidoId == null) {
            throw new IllegalArgumentException("Order id must not be null");
        }
        if (pedidoRepository.findById(pedidoId).isEmpty()) {
            throw new IllegalArgumentException("Order not found: " + pedidoId);
        }
        pedidoRepository.deleteById(pedidoId);
    }
}

