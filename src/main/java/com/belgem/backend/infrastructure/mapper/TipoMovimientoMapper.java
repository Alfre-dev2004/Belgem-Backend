package com.belgem.backend.infrastructure.mapper;

import com.belgem.backend.domain.model.TipoMovimiento;
import com.belgem.backend.infrastructure.adapter.output.persistence.jpa.TipoMovimientoJpaEntity;

/**
 * Mapper para convertir entre dominio y entidad JPA
 */
public final class TipoMovimientoMapper {

    private TipoMovimientoMapper() {
        // Constructor privado para evitar instanciación
    }


    public static TipoMovimiento toDomain(TipoMovimientoJpaEntity e){
        if(e == null) return null;
        return new TipoMovimiento(e.getId(), e.getNombre(), e.getDescripcion());
    }

    public static TipoMovimientoJpaEntity toEntity(TipoMovimiento d){
        if(d == null) return null;
        return new TipoMovimientoJpaEntity(d.getId(), d.getNombre(), d.getDescripcion());
    }
}
