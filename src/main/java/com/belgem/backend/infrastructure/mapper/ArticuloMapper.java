package com.belgem.backend.infrastructure.mapper;

import com.belgem.backend.domain.model.Articulo;
import com.belgem.backend.application.dto.articulo.CrearArticuloRequest;
import com.belgem.backend.application.dto.articulo.ActualizarArticuloRequest;
import com.belgem.backend.application.dto.articulo.ArticuloResponse;
import com.belgem.backend.infrastructure.adapter.output.persistence.jpa.ArticuloJpaEntity;
import org.springframework.stereotype.Component;

/**
 * Mapper responsable de convertir entre {@link Articulo} (dominio)
 * y {@link ArticuloJpaEntity} (infraestructura).
 */
@Component
public class ArticuloMapper {


    //       DTO → DOMINIO

    public Articulo toDomain(CrearArticuloRequest request) {
        return new Articulo(
                null, // ID aún no existe
                request.nombre(),
                request.situacion(),
                request.pvpMinimo(),
                request.pesoKg(),
                request.altoCm(),
                request.anchoCm(),
                request.largoCm(),
                request.vendible()
        );
    }

    public Articulo toDomain(ActualizarArticuloRequest request, Long id) {
        return new Articulo(
                id,
                request.nombre(),
                request.situacion(),
                request.pvpMinimo(),
                request.pesoKg(),
                request.altoCm(),
                request.anchoCm(),
                request.largoCm(),
                request.vendible()
        );
    }


    //       DOMINIO → DTO

    public ArticuloResponse toResponse(Articulo articulo) {
        return new ArticuloResponse(
                articulo.getId(),
                articulo.getNombre(),
                articulo.getSituacion(),
                articulo.getPvpMinimo(),
                articulo.getPesoKg(),
                articulo.getAltoCm(),
                articulo.getAnchoCm(),
                articulo.getLargoCm(),
                articulo.getVendible()
        );
    }

    //       DOMINIO → JPA


    public ArticuloJpaEntity toEntity(Articulo articulo) {
        return new ArticuloJpaEntity(
                articulo.getId(),
                articulo.getNombre(),
                articulo.getSituacion(),
                articulo.getPvpMinimo(),
                articulo.getPesoKg(),
                articulo.getAltoCm(),
                articulo.getAnchoCm(),
                articulo.getLargoCm(),
                articulo.getVendible()
        );
    }


    //       JPA → DOMINIO


    public Articulo toDomain(ArticuloJpaEntity entity) {
        return new Articulo(
                entity.getId(),
                entity.getNombre(),
                entity.getSituacion(),
                entity.getPvpMinimo(),
                entity.getPesoKg(),
                entity.getAltoCm(),
                entity.getAnchoCm(),
                entity.getLargoCm(),
                entity.getVendible()
        );
    }
}
