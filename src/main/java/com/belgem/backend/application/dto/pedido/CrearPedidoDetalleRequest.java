package com.belgem.backend.application.dto.pedido;

import java.math.BigDecimal;

public class CrearPedidoDetalleRequest {

    private Long articuloId;
    private Integer cantidad;
    private BigDecimal precioUnitario;

    public CrearPedidoDetalleRequest() {}

    public Long getArticuloId() { return articuloId; }
    public void setArticuloId(Long articuloId) { this.articuloId = articuloId; }

    public Integer getCantidad() { return cantidad; }
    public void setCantidad(Integer cantidad) { this.cantidad = cantidad; }

    public BigDecimal getPrecioUnitario() { return precioUnitario; }
    public void setPrecioUnitario(BigDecimal precioUnitario) { this.precioUnitario = precioUnitario; }
}
