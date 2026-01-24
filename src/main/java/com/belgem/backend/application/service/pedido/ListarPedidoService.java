package com.belgem.backend.application.service.pedido;

import com.belgem.backend.domain.model.Pedido;
import com.belgem.backend.domain.port.input.ListarPedidoUseCase;
import com.belgem.backend.domain.port.output.PedidoRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListarPedidoService implements ListarPedidoUseCase {

    private final PedidoRepositoryPort pedidoRepository;

    public ListarPedidoService(PedidoRepositoryPort pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @Override
    public List<Pedido> findAll() {
        return pedidoRepository.findAll();
    }
}

