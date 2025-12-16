package com.belgem.backend.domain.port.input;

import com.belgem.backend.domain.model.Proveedor;
/**
 * Caso de uso para crear un nuevo {@link Proveedor}.
 */
public interface CrearProveedorUseCase {
    Proveedor crear(Proveedor Proveedor);
}