package com.belgem.backend.application.service.proveedor;

import com.belgem.backend.domain.exception.ProveedorNoEncontradoException;
import com.belgem.backend.domain.port.input.EliminarProveedorUseCase;
import com.belgem.backend.domain.port.output.ProveedorRepositoryPort;
import org.springframework.stereotype.Service;

/**
 * Servicio encargado de eliminar un proveedor existente.
 * <p>
 * Este servicio implementa el caso de uso {@link EliminarProveedorUseCase} y se
 * comunica con el repositorio del dominio {@link ProveedorRepositoryPort} para
 * realizar la eliminación. Antes de eliminar, verifica que el proveedor exista.
 * </p>
 *
 * Arquitectura Hexagonal:
 * - No conoce JPA.
 * - Solo trabaja con el puerto de salida.
 * - No maneja DTOs.
 */
@Service
public class EliminarProveedorService implements EliminarProveedorUseCase {

    private final ProveedorRepositoryPort repo;

    public EliminarProveedorService(ProveedorRepositoryPort repo) {
        this.repo = repo;
    }

    @Override
    public void eliminar(Long id) {
        if (!repo.existsById(id)) {
            throw new ProveedorNoEncontradoException(id);
        }
        repo.deleteById(id);
    }
}
