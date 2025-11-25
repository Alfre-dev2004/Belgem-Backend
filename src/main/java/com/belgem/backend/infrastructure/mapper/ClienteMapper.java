package com.belgem.backend.infrastructure.mapper;

import com.belgem.backend.application.dto.cliente.ActualizarClienteRequest;
import com.belgem.backend.application.dto.cliente.ClienteResponse;
import com.belgem.backend.application.dto.cliente.CrearClienteRequest;
import com.belgem.backend.domain.model.Cliente;
import com.belgem.backend.infrastructure.adapter.output.persistence.jpa.ClienteJpaEntity;
import org.springframework.stereotype.Component;

/**
 * Mapper del módulo CLIENTES.
 *
 * Su función es convertir datos entre las diferentes capas:
 *      • DTO  → Dominio
 *      • Dominio → DTO
 *      • Dominio → JPA
 *      • JPA → Dominio
 *  Centraliza todas las transformaciones del módulo.
 */
@Component
public class ClienteMapper {

    /**
     * Convierte un CrearClienteRequest (JSON del frontend)
     * en un Cliente del dominio (modelo de negocio).
     * El ID se deja en null porque la BD lo genera.
     */
    public Cliente toDomain(CrearClienteRequest dto) {
        return new Cliente(
                null,
                dto.getNombre(),
                dto.getNif(),
                dto.getDireccion(),
                dto.getCiudad(),
                dto.getCodigoPostal(),
                dto.getTelefono(),
                dto.getEmail(),
                dto.getTipoCliente(),
                dto.getZona(),
                dto.getRepresentante(),
                dto.getObservaciones()
        );
    }

    /**
     * Convierte un DTO de actualización + ID de la URL
     * en un Cliente del dominio.
     * Permite reutilizar la lógica del dominio para validaciones.
     */
    public Cliente toDomain(Long id, ActualizarClienteRequest dto) {
        return new Cliente(
                id,
                dto.getNombre(),
                null,
                dto.getDireccion(),
                dto.getCiudad(),
                dto.getCodigoPostal(),
                dto.getTelefono(),
                dto.getEmail(),
                dto.getTipoCliente(),
                dto.getZona(),
                dto.getRepresentante(),
                dto.getObservaciones()
        );
    }

    /**
     * Convierte un Cliente del dominio en un DTO que se envía al frontend.
     * Este es el objeto que la API devuelve.
     */
    public ClienteResponse toResponse(Cliente cliente) {
        return new ClienteResponse(
                cliente.getId(),
                cliente.getNombre(),
                cliente.getNif(),
                cliente.getDireccion(),
                cliente.getCiudad(),
                cliente.getCodigoPostal(),
                cliente.getTelefono(),
                cliente.getEmail(),
                cliente.getTipoCliente(),
                cliente.getZona(),
                cliente.getRepresentante(),
                cliente.getObservaciones()
        );
    }

    /**
     * Convierte el dominio en una entidad JPA lista para persistir.
     * Esta conversión se usa en ClientePersistenceAdapter.
     */
    public ClienteJpaEntity toJpaEntity(Cliente cliente) {
        ClienteJpaEntity entity = new ClienteJpaEntity(
                cliente.getNombre(),
                cliente.getNif(),
                cliente.getDireccion(),
                cliente.getCiudad(),
                cliente.getCodigoPostal(),
                cliente.getTelefono(),
                cliente.getEmail(),
                cliente.getTipoCliente(),
                cliente.getZona(),
                cliente.getRepresentante(),
                cliente.getObservaciones()
        );
        // Si el cliente ya tiene ID, lo asignamos
        entity.setId(cliente.getId());
        return entity;
    }

    /**
     * Convierte una entidad ClienteJpaEntity proveniente de la BD
     * en una entidad del dominio Cliente.
     */
    public Cliente toDomain(ClienteJpaEntity entity) {
        return new Cliente(
                entity.getId(),
                entity.getNombre(),
                entity.getNif(),
                entity.getDireccion(),
                entity.getCiudad(),
                entity.getCodigoPostal(),
                entity.getTelefono(),
                entity.getEmail(),
                entity.getTipoCliente(),
                entity.getZona(),
                entity.getRepresentante(),
                entity.getObservaciones()
        );
    }
}
