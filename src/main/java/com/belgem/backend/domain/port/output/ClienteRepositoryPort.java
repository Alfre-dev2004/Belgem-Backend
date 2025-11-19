package com.belgem.backend.domain.port.output;

import com.belgem.backend.domain.model.Cliente;
import java.util.List;
import java.util.Optional;

public interface ClienteRepositoryPort {
    Cliente save(Cliente cliente);
    Optional<Cliente> findById(Long clienteId);
    List<Cliente> findAll();
    void deleteById(Long clienteId);
    boolean existsById(Long clienteId);
}