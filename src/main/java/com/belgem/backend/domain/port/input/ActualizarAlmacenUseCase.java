package com.belgem.backend.domain.port.input;
/**
 * Caso de uso para actualizar los datos de un almacén existente.
 */

import com.belgem.backend.domain.model.Almacen;

public interface ActualizarAlmacenUseCase {
    Almacen actualizar(Long id, Almacen datosNuevos);
}
