package com.belgem.backend.application.dto.articulo;

public record ActualizarArticuloRequest(Integer cantidad,
                                        Double dto,
                                        String nombre,
                                        Double precio) {
}
