package com.belgem.backend.service;

import com.belgem.backend.entity.Cliente;
import com.belgem.backend.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicio que gestiona la lógica de negocio del módulo Cliente.
 *
 * Usa {@link ClienteRepository} para interactuar con la base de datos
 * y ofrece métodos CRUD utilizados por el controlador.
 */
@Service
public class ClienteService {

    private final ClienteRepository repo;

    public ClienteService(ClienteRepository repo) {
        this.repo = repo;
    }

    public List<Cliente> listar() {
        return repo.findAll();
    }

    public Cliente crear(Cliente c) {
        return repo.save(c);
    }

    /** Actualiza un cliente existente por su ID. */
    public Cliente actualizar(Long id, Cliente datos) {
        Cliente c = repo.findById(id)
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
        return repo.save(c);
    }

    /** Elimina un cliente por su ID. */
    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}
