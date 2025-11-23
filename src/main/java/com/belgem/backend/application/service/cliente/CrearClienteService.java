package com.belgem.backend.application.service.cliente;

import com.belgem.backend.domain.model.Cliente;
import com.belgem.backend.domain.port.input.CrearClienteUseCase;
import com.belgem.backend.domain.port.output.ClienteRepositoryPort;
import org.springframework.stereotype.Service;

/**
 * Esta clase  se comunica unicamente con los puertos de entrada
 * y salida. No conoce nada de la tecnologia concreta de persistencia.
 */
@Service
public class CrearClienteService implements CrearClienteUseCase {


    /**
     * Puerto de salida hacia la capa de persistencia.
     * Permite guardar un cliente.
     */
    private final ClienteRepositoryPort repo;

    /**
     * Constructor con inyección de dependencias.
     * Spring se encarga de proporcionar automáticamente la implementación
     * del repositorio.
     */
    public CrearClienteService(ClienteRepositoryPort repo) {
        this.repo = repo;
    }

    @Override
    public Cliente crearCliente(Cliente cliente) {
        // Delegamos directamente en el repositorio.
        return repo.save(cliente);
    }
}



