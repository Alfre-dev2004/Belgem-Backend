package com.belgem.backend.infrastructure.mapper;

import com.belgem.backend.application.dto.MovimientoStock.CrearMovimientoStockRequest;
import com.belgem.backend.application.dto.MovimientoStock.MovimientoStockResponse;
import com.belgem.backend.domain.model.MovimientoStock;

import java.time.LocalDateTime;

/**
 * Mapper para convertir entre DTOs y dominio de MovimientoStock.
 */
public class MovimientoStockMapper {

    public static MovimientoStock toDomain(CrearMovimientoStockRequest request) {
        return new MovimientoStock(
                null,
                request.getArticuloId(),
                request.getAlmacenId(),
                request.getTipoMovimientoId(),
                request.getCantidad(),
                LocalDateTime.now(),
                request.getMotivo(),
                request.getObservaciones()
        );
    }

    public static MovimientoStockResponse toResponse(MovimientoStock movimientoStock) {
        return new MovimientoStockResponse(
                movimientoStock.getId(),
                movimientoStock.getArticuloId(),
                movimientoStock.getAlmacenId(),
                movimientoStock.getTipoMovimientoId(),
                movimientoStock.getCantidad(),
                movimientoStock.getFecha(),
                movimientoStock.getMotivo(),
                movimientoStock.getObservaciones()
        );
    }
}