package com.belgem.backend.application.dto.articulo;

public record ArticuloResponse(Long id,
                               Integer cantidad,
                               Double dto,
                               String nombre,
                               Double precio) {
}
