package com.belgem.backend.infrastructure.adapter.output.persistence.jpa;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "movimiento_stock", schema = "belgem")
public class MovimientoStockJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "articulo_id", nullable = false)
    private Long articuloId;

    @Column(name = "almacen_id", nullable = false)
    private Long almacenId;

    @Column(name = "tipo_movimiento_id", nullable = false)
    private Long tipoMovimientoId;

    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    @Column(name = "fecha", nullable = false)
    private LocalDateTime fecha;

    @Column(name = "motivo")
    private String motivo;

    @Column(name = "observaciones")
    private String observaciones;

    public MovimientoStockJpaEntity() {
    }

    public MovimientoStockJpaEntity(Long id,
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

    public void setId(Long id) {
        this.id = id;
    }

    public void setArticuloId(Long articuloId) {
        this.articuloId = articuloId;
    }

    public void setAlmacenId(Long almacenId) {
        this.almacenId = almacenId;
    }

    public void setTipoMovimientoId(Long tipoMovimientoId) {
        this.tipoMovimientoId = tipoMovimientoId;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}