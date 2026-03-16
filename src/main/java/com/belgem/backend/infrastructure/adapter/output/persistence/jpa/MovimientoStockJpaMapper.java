package com.belgem.backend.infrastructure.adapter.output.persistence.jpa;


import com.belgem.backend.domain.model.MovimientoStock;
import org.springframework.stereotype.Component;

@Component
public class MovimientoStockJpaMapper {

    public MovimientoStockJpaEntity toEntity(MovimientoStock domain) {
        return new MovimientoStockJpaEntity(
                domain.getId(),
                domain.getArticuloId(),
                domain.getAlmacenId(),
                domain.getTipoMovimientoId(),
                domain.getCantidad(),
                domain.getFecha(),
                domain.getMotivo(),
                domain.getObservaciones()
        );
    }

    public MovimientoStock toDomain(MovimientoStockJpaEntity entity) {
        return new MovimientoStock(
                entity.getId(),
                entity.getArticuloId(),
                entity.getAlmacenId(),
                entity.getTipoMovimientoId(),
                entity.getCantidad(),
                entity.getFecha(),
                entity.getMotivo(),
                entity.getObservaciones()
        );
    }
}