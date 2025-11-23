package com.belgem.backend.application.service.cliente;

import com.belgem.backend.domain.model.Cliente;
import com.belgem.backend.domain.port.input.ActualizarClienteUseCase;
import com.belgem.backend.domain.port.output.ClienteRepositoryPort;
import org.springframework.stereotype.Service;

@Service
public class ActualizarClienteService implements ActualizarClienteUseCase {

    /**
     * Puerto de salida hacia la capa de persistencia.
     * Permite guardar o recuperar clientes sin depender de ninguna tecnología concreta
     * (como JPA, Mongo, Supabase, etc.).
     */
    private final ClienteRepositoryPort repo;

    public ActualizarClienteService(ClienteRepositoryPort repo) {
        this.repo = repo;
    }


    /**
     * Método principal del caso de uso para actualizar un cliente.
     *
     * @param id ID del cliente que se desea actualizar.
     * @param clienteActualizado Datos nuevos recibidos desde el controlador.
     * @return El cliente actualizado, después de guardarse en la base de datos.
     */
    @Override
    public Cliente actualizarCliente(Long id, Cliente clienteActualizado) {

        // Creamos una nueva instancia del modelo Cliente asegurando que el ID sea el correcto.
        // Esto evita que el cliente intente actualizarse con un ID erróneo o manipulable.

        Cliente clienteConId = new Cliente(
                id,
                clienteActualizado.getNombre(),
                clienteActualizado.getNif(),
                clienteActualizado.getDireccion(),
                clienteActualizado.getCiudad(),
                clienteActualizado.getCodigoPostal(),
                clienteActualizado.getTelefono(),
                clienteActualizado.getEmail(),
                clienteActualizado.getTipoCliente(),
                clienteActualizado.getZona(),
                clienteActualizado.getRepresentante(),
                clienteActualizado.getObservaciones()
        );
        // Llamamos al repositorio para guardar el cliente actualizado.
        return repo.save(clienteConId);
    }
}

