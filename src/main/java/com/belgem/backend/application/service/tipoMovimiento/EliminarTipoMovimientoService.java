package com.belgem.backend.application.service.tipoMovimiento;


import com.belgem.backend.domain.port.input.EliminarTipoMovimientoUseCase;
import com.belgem.backend.domain.port.output.TipoMovimientoRepositoryPort;
import org.springframework.stereotype.Service;

/**
 * Implementación del caso de uso {@link EliminarTipoMovimientoUseCase}.
 */
@Service
public class EliminarTipoMovimientoService implements EliminarTipoMovimientoUseCase {

    private final TipoMovimientoRepositoryPort repository;

    public EliminarTipoMovimientoService(TipoMovimientoRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public void eliminar(Long id) {
        if (id == null) throw new IllegalArgumentException("El id es obligatorio");

        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("TipoMovimiento no encontrado con id: " + id);
        }
        repository.deleteById(id);
    }
}