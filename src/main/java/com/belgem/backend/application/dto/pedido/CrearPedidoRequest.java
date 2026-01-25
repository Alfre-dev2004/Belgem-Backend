package com.belgem.backend.application.dto.pedido;

/**
 * DTO para crear un pedido
 */
public class CrearPedidoRequest {

    private Long clienteId;
    private Long representanteId;
    private String observaciones;

    public CrearPedidoRequest() {}

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public Long getRepresentanteId() {
        return representanteId;
    }

    public void setRepresentanteId(Long representanteId) {
        this.representanteId = representanteId;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}

