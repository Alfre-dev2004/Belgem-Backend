package com.belgem.backend.application.service.pedido;


import com.belgem.backend.domain.model.Pedido;
import com.belgem.backend.domain.port.input.ActualizarPedidoUseCase;
import com.belgem.backend.domain.port.output.PedidoRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ActualizarPedidoService implements ActualizarPedidoUseCase {

    private static final Set<String> ALLOWED_STATUSES =
            Set.of("CREATED", "CONFIRMED", "CANCELLED", "DELIVERED");

    private final PedidoRepositoryPort pedidoRepository;

    public ActualizarPedidoService(PedidoRepositoryPort pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @Override
    public Pedido updateStatus(Long pedidoId, String newStatus) {
        if (pedidoId == null) {
            throw new IllegalArgumentException("Order id must not be null");
        }
        if (newStatus == null || newStatus.isBlank()) {
            throw new IllegalArgumentException("Order status must not be blank");
        }
        if (!ALLOWED_STATUSES.contains(newStatus)) {
            throw new IllegalArgumentException("Invalid order status: " + newStatus);
        }

        Pedido pedido = pedidoRepository.findById(pedidoId)
                .orElseThrow(() -> new IllegalArgumentException("Order not found: " + pedidoId));

        pedido.setEstado(newStatus);

        // total is not recalculated yet.
        // TODO: Recalculate total using PedidoDetalle once PedidoDetalle module is implemented.

        return pedidoRepository.save(pedido);
    }
}

