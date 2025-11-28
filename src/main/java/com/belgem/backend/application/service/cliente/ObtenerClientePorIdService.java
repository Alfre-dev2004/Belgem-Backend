package com.belgem.backend.application.service.cliente;

import com.belgem.backend.domain.model.Cliente;
import com.belgem.backend.domain.port.input.ObtenerClientePorIdUseCase;
import com.belgem.backend.domain.port.output.ClienteRepositoryPort;
import org.springframework.stereotype.Service;

/**
 * Servicio encargado de manejar el caso de uso de obtención de un cliente
 * por su identificador único (ID).
 */
@Service
public class ObtenerClientePorIdService implements ObtenerClientePorIdUseCase {

    private final ClienteRepositoryPort repo;

    public ObtenerClientePorIdService(ClienteRepositoryPort repo) {
        this.repo = repo;
    }

    //Caso de uso para obtener un cliente mediante su ID.
    @Override
    public Cliente obtenerPorId(Long id) {
        return repo.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Client with id " + id + " not found.")
                );
    }
}
