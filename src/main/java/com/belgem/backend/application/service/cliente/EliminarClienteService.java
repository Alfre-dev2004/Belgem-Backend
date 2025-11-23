package com.belgem.backend.application.service.cliente;

import com.belgem.backend.domain.port.input.EliminarClienteUseCase;
import com.belgem.backend.domain.port.output.ClienteRepositoryPort;
import org.springframework.stereotype.Service;

@Service
public class EliminarClienteService implements EliminarClienteUseCase {

    // Puerto de salida hacia la capa de persistencia.
    private final ClienteRepositoryPort repo;

    //constructor con inyección de dependencias.
    public EliminarClienteService(ClienteRepositoryPort repo) {
        this.repo = repo;
    }

    //Caso de uso para crear un nuevo cliente.
    @Override
    public void eliminarCliente(Long id) {
        repo.deleteById(id);
    }
}

