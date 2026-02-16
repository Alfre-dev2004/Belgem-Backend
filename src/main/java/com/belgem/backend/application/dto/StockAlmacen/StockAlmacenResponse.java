package com.belgem.backend.application.dto.StockAlmacen;

/**
 * DTO de salida utilizado para devolver al frontend
 * la información del stock de un artículo en un almacén.
 *
 * Este objeto se envía como respuesta en endpoints GET.
 *
 * No contiene lógica, solo expone datos del dominio
 * en un formato seguro para el cliente.
 */
public class StockAlmacenResponse {

    private final Long id;
    private final Long articuloId;
    private final Long almacenId;
    private final Integer stockActual;

    public StockAlmacenResponse(Long id, Long articuloId, Long almacenId, Integer stockActual) {
        this.id = id;
        this.articuloId = articuloId;
        this.almacenId = almacenId;
        this.stockActual = stockActual;
    }

    public Long getId() {
        return id;
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
