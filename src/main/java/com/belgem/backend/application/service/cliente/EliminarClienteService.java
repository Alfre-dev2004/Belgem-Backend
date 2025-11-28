package com.belgem.backend.application.service.cliente;

import com.belgem.backend.domain.port.input.EliminarClienteUseCase;
import com.belgem.backend.domain.port.output.ClienteRepositoryPort;
import org.springframework.stereotype.Service;

@Service
public class EliminarClienteService implements EliminarClienteUseCase {

    // Puerto de salida hacia la capa de persistencia.
    private final ClienteRepositoryPort repo;

    // Inyección por constructor.
    public EliminarClienteService(ClienteRepositoryPort repo) {
        this.repo = repo;
    }

    /**
     * Caso de uso para eliminar un cliente.
     * Antes de borrar se comprueba que el cliente exista.
     */
    @Override
    public void eliminarCliente(Long id) {

        // Validar si existe antes de eliminar
        if (!repo.existsById(id)) {
            throw new IllegalArgumentException("Client with id " + id + " not found.");        }

        // Si existe, se elimina
        repo.deleteById(id);
    }
}


