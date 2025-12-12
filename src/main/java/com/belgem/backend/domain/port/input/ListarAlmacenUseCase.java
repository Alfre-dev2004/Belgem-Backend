package com.belgem.backend.domain.port.input;
/**
 * Caso de uso para obtener la lista completa de almacenes registrados.
 */

import com.belgem.backend.domain.model.Almacen;

import java.util.List;

public interface ListarAlmacenUseCase {
    List<Almacen> listar();
}
