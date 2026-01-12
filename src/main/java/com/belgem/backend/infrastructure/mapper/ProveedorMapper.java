package com.belgem.backend.infrastructure.mapper;

import com.belgem.backend.domain.model.Proveedor;
import com.belgem.backend.application.dto.proveedor.CrearProveedorRequest;
import com.belgem.backend.application.dto.proveedor.ActualizarProveedorRequest;
import com.belgem.backend.application.dto.proveedor.ProveedorResponse;
import com.belgem.backend.infrastructure.adapter.output.persistence.jpa.ProveedorJpaEntity;
import org.springframework.stereotype.Component;

/**
 * Mapper responsable de convertir entre {@link Proveedor} (dominio)
 * y {@link ProveedorJpaEntity} (infraestructura).
 */
@Component
public class ProveedorMapper {

    //       DTO → DOMINIO

    public Proveedor toDomain(CrearProveedorRequest request) {
        return new Proveedor(
                null,                       // ID aún no existe
                request.nombre(),
                request.cif(),
                request.telefono(),
                request.email(),
                request.direccion(),
                request.ciudad(),
                request.pais(),
                true                        // activo por defecto
        );
    }

    public Proveedor toDomain(ActualizarProveedorRequest request, Long id) {
        return new Proveedor(
                id,
                request.nombre(),
                request.cif(),
                request.telefono(),
                request.email(),
                request.direccion(),
                request.ciudad(),
                request.pais(),
                request.activo()
        );
    }

    //       DOMINIO → DTO

    public ProveedorResponse toResponse(Proveedor proveedor) {
        return new ProveedorResponse(
                proveedor.getId(),
                proveedor.getNombre(),
                proveedor.getCif(),
                proveedor.getTelefono(),
                proveedor.getEmail(),
                proveedor.getDireccion(),
                proveedor.getCiudad(),
                proveedor.getPais(),
                proveedor.getActivo()
        );
    }

    //       DOMINIO → JPA

    public ProveedorJpaEntity toEntity(Proveedor proveedor) {
        return new ProveedorJpaEntity(
                proveedor.getId(),
                proveedor.getNombre(),
                proveedor.getCif(),
                proveedor.getTelefono(),
                proveedor.getEmail(),
                proveedor.getDireccion(),
                proveedor.getCiudad(),
                proveedor.getPais(),
                proveedor.getActivo()
        );
    }

    //       JPA → DOMINIO

    public Proveedor toDomain(ProveedorJpaEntity entity) {
        return new Proveedor(
                entity.getId(),
                entity.getNombre(),
                entity.getCif(),
                entity.getTelefono(),
                entity.getEmail(),
                entity.getDireccion(),
                entity.getCiudad(),
                entity.getPais(),
                entity.getActivo()
        );
    }
}
