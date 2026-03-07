package com.belgem.backend.application.dto.StockAlmacen;

/**
 * DTO de entrada utilizado para modificar manualmente
 * el stock actual de un artículo en un almacén.
 *
 * IMPORTANTE:
 * Este DTO solo debería utilizarse si el sistema permite
 * ajustes manuales fuera del módulo de MovimientoStock.
 *
 * Si en el futuro el stock solo se modifica mediante
 * movimientos de stock, este DTO puede eliminarse o no da igual
 * que si se queda creeeo que no pasa nada.
 */
public class ActualizarStockAlmacenRequest {

    private final Integer stockActual;

    public ActualizarStockAlmacenRequest(Integer stockActual) {
        this.stockActual = stockActual;
    }

    public Integer getStockActual() {
        return stockActual;
    }
}