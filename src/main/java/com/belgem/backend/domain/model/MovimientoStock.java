package com.belgem.backend.domain.model;

import java.time.LocalDateTime;

public class MovimientoStock {

    private final Long id;
    private final Long articuloId;
    private final Long almacenId;
    private final Long tipoMovimientoId;
    private final Integer cantidad;
    private final LocalDateTime fecha;
    private final String motivo;
    private final String observaciones;

    public MovimientoStock(Long id,
                           Long articuloId,
                           Long almacenId,
                           Long tipoMovimientoId,
                           Integer cantidad,
                           LocalDateTime fecha,
                           String motivo,
                           String observaciones) {

        if (articuloId == null) {
            throw new IllegalArgumentException("articuloId no puede ser null");
        }

        if (almacenId == null) {
            throw new IllegalArgumentException("almacenId no puede ser null");
        }

        if (tipoMovimientoId == null) {
            throw new IllegalArgumentException("tipoMovimientoId no puede ser null");
        }

        if (cantidad == null || cantidad <= 0) {
            throw new IllegalArgumentException("cantidad debe ser mayor que 0");
        }

        if (fecha == null) {
            throw new IllegalArgumentException("fecha no puede ser null");
        }

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