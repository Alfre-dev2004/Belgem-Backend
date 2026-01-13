package com.belgem.backend.application.service.tipoMovimiento;



import com.belgem.backend.domain.port.input.ListarTipoMovimientoUseCase;
import com.belgem.backend.domain.model.TipoMovimiento;
import com.belgem.backend.domain.port.output.TipoMovimientoRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementación del caso de uso {@link ListarTipoMovimientoUseCase}.
 */
@Service
public class ListarTipoMovimientoService implements ListarTipoMovimientoUseCase {

    private final TipoMovimientoRepositoryPort repository;

    public ListarTipoMovimientoService(TipoMovimientoRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public List<TipoMovimiento> listar() {
        return repository.findAll();
    }
}