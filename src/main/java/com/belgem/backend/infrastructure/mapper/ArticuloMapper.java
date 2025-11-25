package com.belgem.backend.infrastructure.mapper;

import com.belgem.backend.domain.model.Articulo;
import com.belgem.backend.application.dto.articulo.CrearArticuloRequest;
import com.belgem.backend.application.dto.articulo.ActualizarArticuloRequest;
import com.belgem.backend.application.dto.articulo.ArticuloResponse;
import com.belgem.backend.infrastructure.adapter.output.persistence.jpa.ArticuloJpaEntity;
import org.springframework.stereotype.Component;

@Component
public class ArticuloMapper {

    // ============================
    //       DTO → DOMINIO
    // ============================

    public Articulo toDomain(CrearArticuloRequest request) {
        return new Articulo(
                null,                          // ID aún no existe
                request.cantidad(),
                request.dto(),
                request.nombre(),
                request.precio()
        );
    }

    public Articulo toDomain(ActualizarArticuloRequest request, Long id) {
        return new Articulo(
                id,
                request.cantidad(),
                request.dto(),
                request.nombre(),
                request.precio()
        );
    }

    // ============================
    //       DOMINIO → DTO
    // ============================

    public ArticuloResponse toResponse(Articulo articulo) {
        return new ArticuloResponse(
                articulo.getId(),
                articulo.getCantidad(),
                articulo.getDto(),
                articulo.getNombre(),
                articulo.getPrecio()
        );
    }

    // ============================
    //       DOMINIO → JPA
    // ============================

    public ArticuloJpaEntity toEntity(Articulo articulo) {
        return new ArticuloJpaEntity(
                articulo.getId(),
                articulo.getCantidad(),
                articulo.getDto(),
                articulo.getNombre(),
                articulo.getPrecio()
        );
    }

    // ============================
    //       JPA → DOMINIO
    // ============================

    public Articulo toDomain(ArticuloJpaEntity entity) {
        return new Articulo(
                entity.getId(),
                entity.getCantidad(),
                entity.getDto(),
                entity.getNombre(),
                entity.getPrecio()
        );
    }
}
