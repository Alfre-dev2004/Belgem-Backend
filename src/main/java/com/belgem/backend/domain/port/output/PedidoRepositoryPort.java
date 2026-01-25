package com.belgem.backend.domain.port.output;

import com.belgem.backend.domain.model.Pedido;
import java.util.List;
import java.util.Optional;

public interface PedidoRepositoryPort {
    Pedido save(Pedido pedido);
    List<Pedido> findAll();
    Optional<Pedido> findById(Long id);
    void deleteById(Long id);
}


