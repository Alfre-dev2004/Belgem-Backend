package com.belgem.backend.infrastructure.adapter.output.persistence.jpa;

import com.belgem.backend.domain.model.Pedido;
import com.belgem.backend.domain.port.output.PedidoRepositoryPort;
import com.belgem.backend.infrastructure.mapper.PedidoMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PedidoPersistenceAdapter implements PedidoRepositoryPort {

    private final PedidoJpaRepository repo;

    public PedidoPersistenceAdapter(PedidoJpaRepository repo) {
        this.repo = repo;
    }

    @Override
    public Pedido save(Pedido pedido) {
        var saved = repo.save(PedidoMapper.toEntity(pedido));
        return PedidoMapper.toDomain(saved);
    }

    @Override
    public List<Pedido> findAll() {
        return repo.findAll().stream().map(PedidoMapper::toDomain).toList();
    }

    @Override
    public Optional<Pedido> findById(Long id) {
        return repo.findById(id).map(PedidoMapper::toDomain);
    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);
    }
}
