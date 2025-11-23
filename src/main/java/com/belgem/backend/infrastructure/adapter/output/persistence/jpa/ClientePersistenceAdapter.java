package com.belgem.backend.infrastructure.adapter.output.persistence.jpa;

import com.belgem.backend.domain.model.Cliente;
import com.belgem.backend.domain.port.output.ClienteRepositoryPort;
import com.belgem.backend.infrastructure.mapper.ClienteMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


/**
 * Adaptador de persistencia para el módulo CLIENTES.
 * Implementa el puerto de salida ClienteRepositoryPort.
 * Convierte entre Cliente (dominio) y ClienteJpaEntity (JPA) usando ClienteMapper.
 * Es la única clase autorizada a llamar al JpaRepository.
 */
@Component
public class ClientePersistenceAdapter implements ClienteRepositoryPort {

    private final ClienteJpaRepository repository;
    private final ClienteMapper mapper;

    public ClientePersistenceAdapter(ClienteJpaRepository repository, ClienteMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    /**
     * Guarda un cliente en la base de datos.
     * 1. Convierte la entidad de dominio → entidad JPA.
     * 2. Usa repository.save() para persistir.
     * 3. Convierte JPA → dominio para devolver un objeto puro.
     */
    @Override
    public Cliente save(Cliente cliente) {
        ClienteJpaEntity entity = mapper.toJpaEntity(cliente);
        ClienteJpaEntity saved = repository.save(entity);
        return mapper.toDomain(saved);
    }

    /**
     * Busca un cliente por ID.
     * Devuelve Optional<Cliente> (dominio), nunca JPA.
     */
    @Override
    public Optional<Cliente> findById(Long id) {
        return repository.findById(id).map(mapper::toDomain);
    }

    /**
     * Obtiene todos los clientes de la BD.
     * Convierte cada entidad JPA → dominio para mantener la limpieza del modelo.
     */
    @Override
    public List<Cliente> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDomain)
                .toList();
    }

    /**
     * Verifica si un cliente existe por ID.
     */
    @Override
    public boolean existsById(Long id) {
        return repository.existsById(id);
    }

    /**
     * Elimina un cliente por ID.
     */
    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}

