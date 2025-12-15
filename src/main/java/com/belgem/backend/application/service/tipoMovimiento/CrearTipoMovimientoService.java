package com.belgem.backend.application.service.tipoMovimiento;

import com.belgem.backend.domain.port.input.CrearTipoMovimientoUseCase;
import com.belgem.backend.domain.model.TipoMovimiento;
import com.belgem.backend.domain.port.output.TipoMovimientoRepositoryPort;
import org.springframework.stereotype.Service;

/**
 * Implementación del caso de uso {@link CrearTipoMovimientoUseCase}.
 */
@Service
public class CrearTipoMovimientoService implements CrearTipoMovimientoUseCase {

    private final TipoMovimientoRepositoryPort repository;

    public CrearTipoMovimientoService(TipoMovimientoRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public TipoMovimiento crear(TipoMovimiento nuevo) {
        if (nuevo == null) throw new IllegalArgumentException("TipoMovimiento no puede ser null");
        if (nuevo.getNombre() == null || nuevo.getNombre().isBlank()) {
            throw new IllegalArgumentException("El nombre es obligatorio");
        }

        String nombre = nuevo.getNombre().trim();
        if (repository.existsByNombre(nombre)) {
            throw new IllegalArgumentException("Ya existe un TipoMovimiento con nombre: " + nombre);
        }

        nuevo.setNombre(nombre);
        return repository.save(nuevo);
    }
}
