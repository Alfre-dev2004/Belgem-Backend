package com.belgem.backend.infrastructure.mapper;

import com.belgem.backend.application.dto.representante.*;
import com.belgem.backend.domain.model.Representante;
import com.belgem.backend.infrastructure.adapter.output.persistence.jpa.RepresentanteJpaEntity;
import org.springframework.stereotype.Component;

@Component
public class RepresentanteMapper {

    public Representante toDomain(CrearRepresentanteRequest dto) {
        return new Representante(
                null,
                dto.getName(),
                dto.getPhone(),
                dto.getEmail(),
                dto.getZone(),
                dto.getInternalCode(),
                dto.getCommission()
        );
    }

    public Representante toDomain(ActualizarRepresentanteRequest dto) {
        return new Representante(
                null,
                dto.getName(),
                dto.getPhone(),
                dto.getEmail(),
                dto.getZone(),
                dto.getInternalCode(),
                dto.getCommission()
        );
    }

    public RepresentanteResponse toResponse(Representante domain) {
        return new RepresentanteResponse(
                domain.getId(),
                domain.getName(),
                domain.getPhone(),
                domain.getEmail(),
                domain.getZone(),
                domain.getInternalCode(),
                domain.getCommission()
        );
    }

    public RepresentanteJpaEntity toJpa(Representante domain) {
        return new RepresentanteJpaEntity(
                domain.getId(),
                domain.getName(),
                domain.getPhone(),
                domain.getEmail(),
                domain.getZone(),
                domain.getInternalCode(),
                domain.getCommission()
        );
    }

    public Representante toDomain(RepresentanteJpaEntity entity) {
        return new Representante(
                entity.getId(),
                entity.getName(),
                entity.getPhone(),
                entity.getEmail(),
                entity.getZone(),
                entity.getInternalCode(),
                entity.getCommission()
        );
    }
}
