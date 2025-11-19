package com.belgem.backend.application.service; // PAQUETE ACTUALIZADO

import com.belgem.backend.domain.model.Cliente;
import com.belgem.backend.domain.port.input.GestionarClienteUseCase; // IMPLEMENTA PORT DE ENTRADA
import com.belgem.backend.domain.port.output.ClienteRepositoryPort; // INYECTA PORT DE SALIDA
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicio que gestiona la lógica de negocio del módulo Cliente.
 *
 * Usa {@link ClienteRepositoryPort} para interactuar con la base de datos
 * y ofrece métodos CRUD utilizados por el controlador.
 */
@Service
public class ClienteService implements GestionarClienteUseCase { // IMPLEMENTA EL CASO DE USO

    private final ClienteRepositoryPort repositoryPort; // INYECCIÓN DEL PORT DE SALIDA

    public ClienteService(ClienteRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    @Override
    public List<Cliente> listar() {
        return repositoryPort.findAll();
    }

    @Override
    public Cliente crear(Cliente c) {
        return repositoryPort.save(c);
    }

    /** Actualiza un cliente existente por su ID. */
    @Override
    public Cliente actualizar(Long clienteId, Cliente datos) { // ID ACTUALIZADO
        Cliente c = repositoryPort.findById(clienteId) // ID ACTUALIZADO
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        c.setNombre(datos.getNombre());
        c.setNif(datos.getNif());
        c.setDireccion(datos.getDireccion());
        c.setCiudad(datos.getCiudad());
        c.setCodigoPostal(datos.getCodigoPostal());
        c.setTelefono(datos.getTelefono());
        c.setEmail(datos.getEmail());
        c.setTipoCliente(datos.getTipoCliente());
        c.setZona(datos.getZona());
        c.setRepresentante(datos.getRepresentante());
        c.setObservaciones(datos.getObservaciones());
        return repositoryPort.save(c);
    }

    /** Elimina un cliente por su ID. */
    @Override
    public void eliminar(Long clienteId) { // ID ACTUALIZADO
        repositoryPort.deleteById(clienteId); // ID ACTUALIZADO
    }
}