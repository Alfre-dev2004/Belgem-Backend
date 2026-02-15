package com.belgem.backend.application.dto.articulo;

public record ActualizarArticuloRequest(
        String nombre,
        String situacion,
        Double pvpMinimo,
        Double pesoKg,
        Double altoCm,
        Double anchoCm,
        Double largoCm,
        Boolean vendible
) {
}