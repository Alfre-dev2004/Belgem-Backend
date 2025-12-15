package com.belgem.backend.domain.port.input;

import com.belgem.backend.domain.model.TipoMovimiento;
import java.util.List;

/**
 * Puerto de entrada: listar {@link TipoMovimiento}.
 */
public interface ListarTipoMovimientoUseCase {
    List<TipoMovimiento> listar();
}