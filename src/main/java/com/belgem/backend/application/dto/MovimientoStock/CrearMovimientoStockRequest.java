package com.belgem.backend.application.dto.MovimientoStock;

/**
 * DTO de entrada para registrar un movimiento de stock.
 */
public class CrearMovimientoStockRequest {

    private final Long articuloId;
    private final Long almacenId;
    private final Long tipoMovimientoId;
    private final Integer cantidad;
    private final String motivo;
    private final String observaciones;

    public CrearMovimientoStockRequest(Long articuloId,
                                       Long almacenId,
                                       Long tipoMovimientoId,
                                       Integer cantidad,
                                       String motivo,
                                       String observaciones) {
        this.articuloId = articuloId;
        this.almacenId = almacenId;
        this.tipoMovimientoId = tipoMovimientoId;
        this.cantidad = cantidad;
        this.motivo = motivo;
        this.observaciones = observaciones;
    }

    public Long getArticuloId() {
        return articuloId;
    }

    public Long getAlmacenId() {
        return almacenId;
    }

    public Long getTipoMovimientoId() {
        return tipoMovimientoId;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public String getMotivo() {
        return motivo;
    }

    public String getObservaciones() {
        return observaciones;
    }
}