package com.belgem.backend.domain.port.input;

import com.belgem.backend.domain.model.StockAlmacen;

/**
 * Puerto de entrada para crear un nuevo StockAlmacen.
 *
 * Permite registrar un representante en el sistema usando
 * la información proporcionada en un objeto StockAlmacen.
 */
public interface CrearStockAlmacenUseCase {
    StockAlmacen crear(StockAlmacen stockalmacen);
}
