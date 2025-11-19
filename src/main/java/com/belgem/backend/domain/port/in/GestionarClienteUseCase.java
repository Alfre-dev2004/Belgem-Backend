package com.belgem.backend.domain.port.in;

import com.belgem.backend.domain.model.Cliente;
import java.util.List;

public interface GestionarClienteUseCase {
    List<Cliente> listar();
    Cliente crear(Cliente c);
    Cliente actualizar(Long clienteId, Cliente datos);
    void eliminar(Long clienteId);
}