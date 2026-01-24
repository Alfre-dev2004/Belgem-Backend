package com.belgem.backend.domain.port.input;


import com.belgem.backend.domain.model.TipoMovimiento;

/**
 * Puerto de entrada: actualizar un {@link TipoMovimiento}.
 */
public interface ActualizarTipoMovimientoUseCase {
    TipoMovimiento actualizar(Long id, TipoMovimiento cambios);
}