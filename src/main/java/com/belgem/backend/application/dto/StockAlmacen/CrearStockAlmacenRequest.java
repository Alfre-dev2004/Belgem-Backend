package com.belgem.backend.application.dto.StockAlmacen;

/**
 * DTO de entrada utilizado para crear un registro de stock
 * que relaciona un Artículo con un Almacén.
 *
 * Este DTO representa los datos que llegan desde el frontend
 * en formato JSON cuando se quiere inicializar el stock
 * de un artículo en un almacén específico.
 *
 * No contiene lógica de negocio.
 * La validación real se realiza en el dominio.
 */
public class CrearStockAlmacenRequest {

    private final Long articuloId;
    private final Long almacenId;
    private final Integer stockActual;

    public CrearStockAlmacenRequest(Long articuloId, Long almacenId, Integer stockActual) {
        this.articuloId = articuloId;
        this.almacenId = almacenId;
        this.stockActual = stockActual;
    }

    public Long getArticuloId() {
        return articuloId;
    }

    public Long getAlmacenId() {
        return almacenId;
    }

    public Integer getStockActual() {
        return stockActual;
    }
}