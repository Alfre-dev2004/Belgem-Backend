package com.belgem.backend.domain.port.input;

import com.belgem.backend.domain.model.TipoMovimiento;

/**
 * Puerto de entrada: crear un {@link TipoMovimiento}.
 */
public interface CrearTipoMovimientoUseCase {
    TipoMovimiento crear(TipoMovimiento nuevo);
}
