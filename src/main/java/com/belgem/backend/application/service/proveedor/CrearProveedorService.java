package com.belgem.backend.application.service.proveedor;

import com.belgem.backend.domain.model.Proveedor;
import com.belgem.backend.domain.port.input.CrearProveedorUseCase;
import com.belgem.backend.domain.port.output.ProveedorRepositoryPort;
import org.springframework.stereotype.Service;

/**
 * Servicio encargado de crear un nuevo proveedor en el sistema.
 * <p>
 * Implementa el caso de uso {@link CrearProveedorUseCase} y utiliza
 * el puerto de salida {@link ProveedorRepositoryPort} para interactuar con
 * la capa de persistencia. Antes de crear un proveedor, valida que no exista
 * otro proveedor con el mismo nombre, para evitar duplicados en el negocio.
 * </p>
 *
 * Principios de Arquitectura Hexagonal:
 *
 *     -No conoce JPA
 *     -Solo usa el puerto del dominio
 *     -Devuelve entidades del dominio
 *     -No maneja DTOs
 */
@Service
public class CrearProveedorService implements CrearProveedorUseCase {

    private final ProveedorRepositoryPort repo;

    public CrearProveedorService(ProveedorRepositoryPort repo) {
        this.repo = repo;
    }

    @Override
    public Proveedor crear(Proveedor proveedor) {
        if (repo.existsByNombre(proveedor.getNombre())) { // validación para que no se repita por nombre
            throw new IllegalArgumentException("Ya existe un proveedor con ese nombre");
        }
        return repo.save(proveedor);
    }
}
