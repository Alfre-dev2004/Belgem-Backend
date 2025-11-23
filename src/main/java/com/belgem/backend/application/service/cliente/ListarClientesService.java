package com.belgem.backend.application.service.cliente;

import com.belgem.backend.domain.model.Cliente;
import com.belgem.backend.domain.port.input.ListarClientesUseCase;
import com.belgem.backend.domain.port.output.ClienteRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListarClientesService implements ListarClientesUseCase {

    //Puerto de salida para acceder a las operaciones de consulta del repositorio
    private final ClienteRepositoryPort repo;

    public ListarClientesService(ClienteRepositoryPort repo) {
        this.repo = repo;
    }

    // Delegamos en el repositorio la obtención de todos los clientes.
    @Override
    public List<Cliente> listarClientes() {
        return repo.findAll();
    }
}
