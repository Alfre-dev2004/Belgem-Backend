package com.belgem.backend.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Pedido {
    private Long id;
    private Long clienteId;
    private Long representanteId;
    private LocalDateTime fecha;
    private String estado; // o enum si ya usáis enums en dominio
    private BigDecimal total;
    private String observaciones;

    public Pedido(Long id, Long clienteId, Long representanteId, LocalDateTime fecha,
                  String estado, BigDecimal total, String observaciones) {
        this.id = id;
        this.clienteId = clienteId;
        this.representanteId = representanteId;
        this.fecha = fecha;
        this.estado = estado;
        this.total = total;
        this.observaciones = observaciones;
    }

    public static Pedido nuevo(Long clienteId, Long representanteId, String observaciones) {
        return new Pedido(
                null,
                clienteId,
                representanteId,
                LocalDateTime.now(),
                "CREATE",
                BigDecimal.ZERO,
                observaciones
        );
    }

    public Long getId() {
        return id;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public Long getRepresentanteId() {
        return representanteId;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public String getEstado() {
        return estado;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}
