package com.belgem.backend.domain.port.input;

import com.belgem.backend.domain.model.Proveedor;

import java.util.List;

/**
 * Caso de uso para listar todos los proveedores.
 */
public interface ListarProveedoresUseCase {
    List<Proveedor> listar();
}
