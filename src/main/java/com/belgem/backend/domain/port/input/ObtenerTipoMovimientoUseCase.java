package com.belgem.backend.domain.port.input;

import com.belgem.backend.domain.model.TipoMovimiento;

/**
 * Puerto de entrada: obtener un {@link TipoMovimiento} por id.
 */
public interface ObtenerTipoMovimientoUseCase {
    TipoMovimiento obtener(Long id);
}