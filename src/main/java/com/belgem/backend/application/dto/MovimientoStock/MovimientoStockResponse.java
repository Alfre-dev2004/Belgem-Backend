package com.belgem.backend.application.dto.MovimientoStock;

import java.time.LocalDateTime;

/**
 * DTO de salida para devolver un movimiento de stock al frontend.
 */
public class MovimientoStockResponse {

    private final Long id;
    private final Long articuloId;
    private final Long almacenId;
    private final Long tipoMovimientoId;
    private final Integer cantidad;
    private final LocalDateTime fecha;
    private final String motivo;
    private final String observaciones;

    public MovimientoStockResponse(Long id,
                                   Long articuloId,
                                   Long almacenId,
                                   Long tipoMovimientoId,
                                   Integer cantidad,
                                   LocalDateTime fecha,
                                   String motivo,
                                   String observaciones) {
        this.id = id;
        this.articuloId = articuloId;
        this.almacenId = almacenId;
        this.tipoMovimientoId = tipoMovimientoId;
        this.cantidad = cantidad;
        this.fecha = fecha;
        this.motivo = motivo;
        this.observaciones = observaciones;
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

    public Long getTipoMovimientoId() {
        return tipoMovimientoId;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public String getMotivo() {
        return motivo;
    }

    public String getObservaciones() {
        return observaciones;
    }
}