package com.belgem.backend.domain.port.input;

import com.belgem.backend.domain.model.Articulo;
import com.belgem.backend.domain.model.Proveedor;
/**
 * Caso de uso para actualizar un {@link Proveedor} existente.
 */
public interface ActualizarProveedorUseCase {
    Proveedor actualizar(Long id, Proveedor proveedor);
}
