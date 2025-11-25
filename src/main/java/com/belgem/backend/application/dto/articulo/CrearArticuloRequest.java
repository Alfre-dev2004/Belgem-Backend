package com.belgem.backend.application.dto.articulo;

public record CrearArticuloRequest(Integer cantidad,
                                   Double dto,
                                   String nombre,
                                   Double precio) {
}
