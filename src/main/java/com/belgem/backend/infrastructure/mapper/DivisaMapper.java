package com.belgem.backend.infrastructure.mapper;

import com.belgem.backend.application.dto.divisa.ActualizarDivisaRequest;
import com.belgem.backend.application.dto.divisa.CrearDivisaRequest;
import com.belgem.backend.application.dto.divisa.DivisaResponse;
import com.belgem.backend.domain.model.Divisa;
import com.belgem.backend.infrastructure.adapter.output.persistence.jpa.DivisaJpaEntity;
import org.springframework.stereotype.Component;

@Component
public class DivisaMapper {

    // ===== DTO -> Dominio =====

    public Divisa toDomain(CrearDivisaRequest request) {
        if (request == null) return null;
        return new Divisa(
                null,                  // id lo genera la BD
                request.getCode(),
                request.getName()
        );
    }

    public Divisa toDomain(Long id, ActualizarDivisaRequest request) {
        if (request == null) return null;
        return new Divisa(
                id,                    // id viene de la URL
                request.getCode(),
                request.getName()
        );
    }

    // ===== Dominio -> DTO =====

    public DivisaResponse toResponse(Divisa divisa) {
        if (divisa == null) return null;
        return new DivisaResponse(
                divisa.getId(),
                divisa.getCode(),
                divisa.getName()
        );
    }

    // ===== Dominio -> JPA =====

    public DivisaJpaEntity toEntity(Divisa divisa) {
        if (divisa == null) return null;

        DivisaJpaEntity entity = new DivisaJpaEntity();
        entity.setId(divisa.getId());
        entity.setCode(divisa.getCode());
        entity.setName(divisa.getName());
        return entity;
    }

    // ===== JPA -> Dominio =====

    public Divisa toDomain(DivisaJpaEntity entity) {
        if (entity == null) return null;

        return new Divisa(
                entity.getId(),
                entity.getCode(),
                entity.getName()
        );
    }
}
