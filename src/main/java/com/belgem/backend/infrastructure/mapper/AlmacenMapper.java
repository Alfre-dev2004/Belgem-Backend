package com.belgem.backend.infrastructure.mapper;

import com.belgem.backend.application.dto.almacen.ActualizarAlmacenRequest;
import com.belgem.backend.application.dto.almacen.AlmacenResponse;
import com.belgem.backend.application.dto.almacen.CrearAlmacenRequest;
import com.belgem.backend.domain.model.Almacen;
import com.belgem.backend.infrastructure.adapter.output.persistence.jpa.AlmacenJpaEntity;
import org.springframework.stereotype.Component;

@Component
public class AlmacenMapper {

    // ====== DOMAIN → JPA ======
    public AlmacenJpaEntity toEntity(Almacen domain) {
        AlmacenJpaEntity e = new AlmacenJpaEntity();
        e.setId(domain.getId());
        e.setNombre(domain.getNombre());
        e.setDireccion(domain.getDireccion());
        e.setTelefono(domain.getTelefono());
        e.setResponsable(domain.getResponsable());
        e.setActivo(domain.isActivo());
        return e;
    }

    // ====== JPA → DOMAIN ======
    public Almacen toDomain(AlmacenJpaEntity e) {
        return new Almacen(
                e.getId(),
                e.getNombre(),
                e.getDireccion(),
                e.getTelefono(),
                e.getResponsable(),
                e.isActivo()
        );
    }

    // ====== DTO → DOMAIN ======
    public Almacen toDomain(CrearAlmacenRequest req) {
        return new Almacen(
                null,
                req.nombre,
                req.direccion,
                req.telefono,
                req.responsable,
                req.activo
        );
    }

    public Almacen toDomain(ActualizarAlmacenRequest req, Long id, String nombreOriginal) {
        return new Almacen(
                id,
                req.nombre != null ? req.nombre : nombreOriginal,
                req.direccion,
                req.telefono,
                req.responsable,
                req.activo
        );
    }

    // ====== DOMAIN → DTO ======
    public AlmacenResponse toResponse(Almacen a) {
        AlmacenResponse res = new AlmacenResponse();
        res.id = a.getId();
        res.nombre = a.getNombre();
        res.direccion = a.getDireccion();
        res.telefono = a.getTelefono();
        res.responsable = a.getResponsable();
        res.activo = a.isActivo();
        return res;
    }

}
