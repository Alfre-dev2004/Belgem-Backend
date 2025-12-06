package com.belgem.backend.application.service.cliente;

import com.belgem.backend.domain.model.Cliente;
import com.belgem.backend.domain.port.input.ActualizarClienteUseCase;
import com.belgem.backend.domain.port.output.ClienteRepositoryPort;
import org.springframework.stereotype.Service;

@Service
public class ActualizarClienteService implements ActualizarClienteUseCase {


    private final ClienteRepositoryPort repo;

    public ActualizarClienteService(ClienteRepositoryPort repo) {
        this.repo = repo;
    }

    @Override
    public Cliente actualizarCliente(Long id, Cliente datosNuevos) {

        // 1. Verificar si el cliente existe usando findById()
        Cliente existente = repo.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Client with id " + id + " not found.")        );

        // 2. Conservar el NIF original
        String nifOriginal = existente.getNif();

        // 3. Crear cliente actualizado manteniendo el NIF
        Cliente clienteActualizado = new Cliente(
                id,
                datosNuevos.getNombre(),
                nifOriginal,  // NIF NO se actualiza
                datosNuevos.getDireccion(),
                datosNuevos.getCiudad(),
                datosNuevos.getCodigoPostal(),
                datosNuevos.getTelefono(),
                datosNuevos.getEmail(),
                datosNuevos.getTipoCliente(),
                datosNuevos.getZona(),
                datosNuevos.getRepresentante(),
                datosNuevos.getObservaciones()
        );

        // 4. Guardar actualización
        return repo.save(clienteActualizado);
    }
}


