package com.belgem.backend.application.service.tipoMovimiento;

import com.belgem.backend.domain.port.input.ActualizarTipoMovimientoUseCase;
import com.belgem.backend.domain.model.TipoMovimiento;
import com.belgem.backend.domain.port.output.TipoMovimientoRepositoryPort;
import org.springframework.stereotype.Service;

/**
 * Implementación del caso de uso {@link ActualizarTipoMovimientoUseCase}.
 */
@Service
public class ActualizarTipoMovimientoService implements ActualizarTipoMovimientoUseCase {

    private final TipoMovimientoRepositoryPort repository;

    public ActualizarTipoMovimientoService(TipoMovimientoRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public TipoMovimiento actualizar(Long id, TipoMovimiento cambios) {
        if (id == null) throw new IllegalArgumentException("El id es obligatorio");
        if (cambios == null) throw new IllegalArgumentException("Los cambios no pueden ser null");

        TipoMovimiento actual = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("TipoMovimiento no encontrado con id: " + id));

        if (cambios.getNombre() != null && !cambios.getNombre().isBlank()) {
            String nuevoNombre = cambios.getNombre().trim();

            boolean cambiaNombre = actual.getNombre() == null || !nuevoNombre.equalsIgnoreCase(actual.getNombre());
            if (cambiaNombre && repository.existsByNombre(nuevoNombre)) {
                throw new IllegalArgumentException("Ya existe un TipoMovimiento con nombre: " + nuevoNombre);
            }
            actual.setNombre(nuevoNombre);
        }

        if (cambios.getDescripcion() != null) {
            actual.setDescripcion(cambios.getDescripcion());
        }

        return repository.save(actual);
    }
}