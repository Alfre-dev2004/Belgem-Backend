package com.belgem.backend.domain.model;

import java.math.BigDecimal;

public class PedidoDetalle {

    private Long id;
    private Long pedidoId;
    private Long articuloId;
    private Integer cantidad;
    private BigDecimal precioUnitario;
    private BigDecimal subtotal;

    public PedidoDetalle() {
    }

    public PedidoDetalle(Long id, Long pedidoId, Long articuloId, Integer cantidad,
                         BigDecimal precioUnitario, BigDecimal subtotal)
    {
        this.id = id;
        this.pedidoId = pedidoId;
        this.articuloId = articuloId;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.subtotal = subtotal;
    }

    /**
     * Factory: subtotal is computed internally (never received from outside).
     */
    public static PedidoDetalle nuevo(Long pedidoId, Long articuloId, Integer cantidad, BigDecimal precioUnitario)
    {
        BigDecimal computedSubtotal = precioUnitario.multiply(BigDecimal.valueOf(cantidad));
        return new PedidoDetalle(null, pedidoId, articuloId, cantidad, precioUnitario, computedSubtotal);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(Long pedidoId) {
        this.pedidoId = pedidoId;
    }

    public Long getArticuloId() {
        return articuloId;
    }

    public void setArticuloId(Long articuloId) {
        this.articuloId = articuloId;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }
}