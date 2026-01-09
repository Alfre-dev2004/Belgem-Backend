package com.belgem.backend.application.service.tipoMovimiento;


import com.belgem.backend.domain.port.input.ObtenerTipoMovimientoUseCase;
import com.belgem.backend.domain.model.TipoMovimiento;
import com.belgem.backend.domain.port.output.TipoMovimientoRepositoryPort;
import org.springframework.stereotype.Service;

/**
 * Implementación del caso de uso {@link ObtenerTipoMovimientoUseCase}.
 */
@Service
public class ObtenerTipoMovimientoService implements ObtenerTipoMovimientoUseCase {

    private final TipoMovimientoRepositoryPort repository;

    public ObtenerTipoMovimientoService(TipoMovimientoRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public TipoMovimiento obtener(Long id) {
        if (id == null) throw new IllegalArgumentException("El id es obligatorio");

        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("TipoMovimiento no encontrado con id: " + id));
    }
}