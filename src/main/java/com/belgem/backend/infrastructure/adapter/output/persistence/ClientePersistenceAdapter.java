package com.belgem.backend.infrastructure.adapter.output.persistence;

import com.belgem.backend.domain.model.Cliente;
import com.belgem.backend.domain.port.output.ClienteRepositoryPort;
import com.belgem.backend.infrastructure.adapter.out.persistence.jpa.ClienteJpaEntity;
import com.belgem.backend.infrastructure.adapter.out.persistence.jpa.ClienteJpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ClientePersistenceAdapter implements ClienteRepositoryPort {

    private final ClienteJpaRepository jpaRepository;

    public ClientePersistenceAdapter(ClienteJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    // --- MAPPERS ESTATÍCOS ---

    private static Cliente toDomainEntity(ClienteJpaEntity jpa) {
        Cliente domain = new Cliente();
        domain.setClienteId(jpa.getId());
        domain.setNombre(jpa.getNombre());
        domain.setEmail(jpa.getEmail());
        domain.setTelefono(jpa.getTelefono());

        domain.setNif(jpa.getNif());
        domain.setDireccion(jpa.getDireccion());
        domain.setCiudad(jpa.getCiudad());
        domain.setCodigoPostal(jpa.getCodigoPostal());
        domain.setTipoCliente(jpa.getTipoCliente());
        domain.setZona(jpa.getZona());
        domain.setObservaciones(jpa.getObservaciones());
        return domain;
    }

    private static ClienteJpaEntity toJpaEntity(Cliente domain) {
        ClienteJpaEntity jpa = new ClienteJpaEntity();
        jpa.setId(domain.getClienteId());
        jpa.setNombre(domain.getNombre());
        jpa.setEmail(domain.getEmail());
        jpa.setTelefono(domain.getTelefono());

        jpa.setNif(domain.getNif());
        jpa.setDireccion(domain.getDireccion());
        jpa.setCiudad(domain.getCiudad());
        jpa.setCodigoPostal(domain.getCodigoPostal());
        jpa.setTipoCliente(domain.getTipoCliente());
        jpa.setZona(domain.getZona());
        jpa.setObservaciones(domain.getObservaciones());
        return jpa;
    }

    // --- IMPLEMENTACIÓN DE PUERTO ---

    @Override
    public Cliente save(Cliente cliente) {
        ClienteJpaEntity jpaEntity = toJpaEntity(cliente);
        ClienteJpaEntity saved = jpaRepository.save(jpaEntity);
        return toDomainEntity(saved);
    }

    @Override
    public Optional<Cliente> findById(Long clienteId) {
        return jpaRepository.findById(clienteId)
                .map(ClientePersistenceAdapter::toDomainEntity);
    }

    @Override
    public List<Cliente> findAll() {
        return jpaRepository.findAll().stream()
                .map(ClientePersistenceAdapter::toDomainEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long clienteId) {
        jpaRepository.deleteById(clienteId);
    }

    @Override
    public boolean existsById(Long clienteId) {
        return jpaRepository.existsById(clienteId);
    }
}