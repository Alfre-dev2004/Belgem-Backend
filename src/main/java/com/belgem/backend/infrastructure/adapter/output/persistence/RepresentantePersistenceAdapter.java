package com.belgem.backend.infrastructure.adapter.output.persistence;

import com.belgem.backend.domain.model.Representante;
import com.belgem.backend.domain.port.output.RepresentanteRepositoryPort;
import com.belgem.backend.infrastructure.adapter.out.persistence.jpa.RepresentanteJpaEntity;
import com.belgem.backend.infrastructure.adapter.out.persistence.jpa.RepresentanteJpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class RepresentantePersistenceAdapter implements RepresentanteRepositoryPort {

    private final RepresentanteJpaRepository jpaRepository;

    public RepresentantePersistenceAdapter(RepresentanteJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    // --- MAPPERS ESTATÍCOS ---
    private static RepresentanteJpaEntity toJpaEntity(Representante domain) {
        RepresentanteJpaEntity jpa = new RepresentanteJpaEntity();
        jpa.setIdRepresentante(domain.getRepresentanteId());
        jpa.setNombre(domain.getNombre());
        jpa.setTelefono(domain.getTelefono());
        jpa.setEmail(domain.getEmail());
        jpa.setZona(domain.getZona());
        jpa.setCodigoInterno(domain.getCodigoInterno());
        jpa.setComision(domain.getComision());
        return jpa;
    }

    private static Representante toDomainEntity(RepresentanteJpaEntity jpa) {
        Representante domain = new Representante();
        domain.setRepresentanteId(jpa.getIdRepresentante());
        domain.setNombre(jpa.getNombre());
        domain.setTelefono(jpa.getTelefono());
        domain.setEmail(jpa.getEmail());
        domain.setZona(jpa.getZona());
        domain.setCodigoInterno(jpa.getCodigoInterno());
        domain.setComision(jpa.getComision());
        return domain;
    }
    // --- IMPLEMENTACIÓN DE PUERTO ---

    @Override
    public Representante save(Representante representante) {
        RepresentanteJpaEntity jpaEntity = toJpaEntity(representante);
        RepresentanteJpaEntity saved = jpaRepository.save(jpaEntity);
        return toDomainEntity(saved);
    }

    @Override
    public Optional<Representante> findById(Long representanteId) {
        return jpaRepository.findById(representanteId)
                .map(RepresentantePersistenceAdapter::toDomainEntity);
    }

    @Override
    public boolean existsById(Long representanteId) {
        return jpaRepository.existsById(representanteId);
    }

    @Override
    public List<Representante> findAll() {
        return jpaRepository.findAll().stream()
                .map(RepresentantePersistenceAdapter::toDomainEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long representanteId) {
        jpaRepository.deleteById(representanteId);
    }

    @Override
    public Optional<Representante> findByEmail(String email) {
        return jpaRepository.findByEmail(email)
                .map(RepresentantePersistenceAdapter::toDomainEntity);
    }

    @Override
    public boolean existsByEmail(String email) {
        return jpaRepository.existsByEmail(email);
    }
}