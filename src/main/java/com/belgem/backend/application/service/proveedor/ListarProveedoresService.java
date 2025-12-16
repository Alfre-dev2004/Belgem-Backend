package com.belgem.backend.application.service.proveedor;

import com.belgem.backend.domain.model.Proveedor;
import com.belgem.backend.domain.port.input.ListarProveedoresUseCase;
import com.belgem.backend.domain.port.output.ProveedorRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicio encargado de listar todos los proveedores disponibles.
 * <p>
 * Implementa el caso de uso {@link ListarProveedoresUseCase} y obtiene
 * la lista de proveedores desde el puerto de salida {@link ProveedorRepositoryPort}.
 * </p>
 *
 * Arquitectura Hexagonal:
 * - No contiene lógica de negocio.
 * - No interactúa con JPA directamente.
 * - Devuelve entidades del dominio.
 */
@Service
public class ListarProveedoresService implements ListarProveedoresUseCase {

    private final ProveedorRepositoryPort repo;

    public ListarProveedoresService(ProveedorRepositoryPort repo) {
        this.repo = repo;
    }

    @Override
    public List<Proveedor> listar() {
        return repo.findAll();
    }
}
