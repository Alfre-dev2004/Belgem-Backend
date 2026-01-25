package com.belgem.backend.application.dto.pedido;


/**
 * DTO for updating Order status
 */
public class ActualizarEstadoRequest {

    private String estado;

    public ActualizarEstadoRequest() {}

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}

