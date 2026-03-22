package com.belgem.backend.application.service.pedido;


import com.belgem.backend.domain.model.PedidoDetalle;
import com.belgem.backend.domain.port.input.ListarPedidoDetalleUseCase;
import com.belgem.backend.domain.port.output.PedidoDetalleRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListarPedidoDetalleService implements ListarPedidoDetalleUseCase {

    private final PedidoDetalleRepositoryPort repository;

    public ListarPedidoDetalleService(PedidoDetalleRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public List<PedidoDetalle> listarPorPedidoId(Long pedidoId) {
        return repository.findByPedidoId(pedidoId);
    }
}