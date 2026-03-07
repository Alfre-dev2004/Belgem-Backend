package com.belgem.backend.infrastructure.mapper;

import com.belgem.backend.application.dto.StockAlmacen.CrearStockAlmacenRequest;
import com.belgem.backend.application.dto.StockAlmacen.StockAlmacenResponse;
import com.belgem.backend.domain.model.StockAlmacen;
import com.belgem.backend.infrastructure.adapter.output.persistence.jpa.StockAlmacenJpaEntity;
import org.springframework.stereotype.Component;

/**
 * Mapper encargado de convertir entre:
 *
 * - DTOs (capa application)
 * - Modelo de dominio (capa domain)
 *
 * Mantiene desacoplado el dominio del exterior.
 */
@Component
public class StockAlmacenMapper {

    /**
     * Convierte un CrearStockAlmacenRequest en una entidad de dominio.
     *
     * Se utiliza cuando el frontend envía datos para crear un stock.
     */
    public static StockAlmacen toDomain(CrearStockAlmacenRequest request) {

        return new StockAlmacen(
                null, // El ID lo genera la base de datos
                request.getArticuloId(),
                request.getAlmacenId(),
                request.getStockActual()
        );
    }

    /**
     * Convierte una entidad de dominio en un DTO de respuesta.
     *
     * Se utiliza cuando se devuelve información al frontend.
     */
    public static StockAlmacenResponse toResponse(StockAlmacen stockAlmacen) {

        return new StockAlmacenResponse(
                stockAlmacen.getId(),
                stockAlmacen.getArticuloId(),
                stockAlmacen.getAlmacenId(),
                stockAlmacen.getStockActual()
        );
    }
    public StockAlmacenJpaEntity toEntity(StockAlmacen domain) {
        return new StockAlmacenJpaEntity(
                domain.getId(),
                domain.getArticuloId(),
                domain.getAlmacenId(),
                domain.getStockActual()
        );
    }
    public StockAlmacen toDomain(StockAlmacenJpaEntity entity) {
        return new StockAlmacen(
                entity.getId(),
                entity.getArticuloId(),
                entity.getAlmacenId(),
                entity.getStockActual()
        );
    }
}
