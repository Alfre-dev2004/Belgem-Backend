package com.belgem.backend.application.service.pedido;

import com.belgem.backend.domain.model.Pedido;
import com.belgem.backend.domain.port.input.ObtenerPedidoUseCase;
import com.belgem.backend.domain.port.output.PedidoRepositoryPort;
import org.springframework.stereotype.Service;

@Service
public class ObtenerPedidoService implements ObtenerPedidoUseCase {
    private final PedidoRepositoryPort pedidoRepositoryPort;
    public ObtenerPedidoService(PedidoRepositoryPort pedidoRepositoryPort) {
        this.pedidoRepositoryPort = pedidoRepositoryPort;
    }
    @Override
    public Pedido ObtenerById(Long id){
        return pedidoRepositoryPort.findById(id).orElseThrow(() -> new IllegalArgumentException("Pedido no encontrado" + id));
    }
}
