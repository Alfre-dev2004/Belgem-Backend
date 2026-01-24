package com.belgem.backend.application.service.pedido;


import com.belgem.backend.domain.model.Pedido;
import com.belgem.backend.domain.port.input.CrearPedidoUseCase;
import com.belgem.backend.domain.port.output.ClienteRepositoryPort;
import com.belgem.backend.domain.port.output.PedidoRepositoryPort;
import org.springframework.stereotype.Service;

@Service
public class CrearPedidoService implements CrearPedidoUseCase {

    private final PedidoRepositoryPort pedidoRepository;
    private final ClienteRepositoryPort clienteRepository;

    public CrearPedidoService(PedidoRepositoryPort pedidoRepository,
                              ClienteRepositoryPort clienteRepository) {
        this.pedidoRepository = pedidoRepository;
        this.clienteRepository = clienteRepository;
    }

    @Override
    public Pedido create(Pedido pedido) {
        if (pedido == null) {
            throw new IllegalArgumentException("Order must not be null");
        }
        if (pedido.getClienteId() == null) {
            throw new IllegalArgumentException("Client id must not be null");
        }

        if (!clienteRepository.existsById(pedido.getClienteId())) {
            throw new IllegalArgumentException("Invalid client id: " + pedido.getClienteId());
        }

        return pedidoRepository.save(pedido);
    }
}
