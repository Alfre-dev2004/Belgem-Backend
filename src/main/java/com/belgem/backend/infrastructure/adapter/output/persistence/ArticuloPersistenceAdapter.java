package com.belgem.backend.infrastructure.adapter.output.persistence;

import com.belgem.backend.domain.model.Articulo;
import com.belgem.backend.domain.port.output.ArticuloRepositoryPort;
import com.belgem.backend.infrastructure.adapter.out.persistence.jpa.ArticuloJpaEntity;
import com.belgem.backend.infrastructure.adapter.out.persistence.jpa.ArticuloJpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ArticuloPersistenceAdapter implements ArticuloRepositoryPort {

    private final ArticuloJpaRepository jpaRepository;

    public ArticuloPersistenceAdapter(ArticuloJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    // --- MAPPERS ESTATÍCOS ---
    private static ArticuloJpaEntity toJpaEntity(Articulo domain) {
        ArticuloJpaEntity jpa = new ArticuloJpaEntity();
        jpa.setArticulo(domain.getArticuloId());
        jpa.setNombre(domain.getNombre());
        jpa.setPrecio(domain.getPrecio());
        jpa.setDto(domain.getDto());
        jpa.setCantidad(domain.getCantidad());
        return jpa;
    }

    private static Articulo toDomainEntity(ArticuloJpaEntity jpa) {
        Articulo domain = new Articulo();
        domain.setArticuloId(jpa.getArticulo());
        domain.setNombre(jpa.getNombre());
        domain.setPrecio(jpa.getPrecio());
        domain.setDto(jpa.getDto());
        domain.setCantidad(jpa.getCantidad());
        return domain;
    }
    // --- IMPLEMENTACIÓN DE PUERTO ---

    @Override
    public Articulo save(Articulo articulo) {
        ArticuloJpaEntity jpaEntity = toJpaEntity(articulo);
        ArticuloJpaEntity saved = jpaRepository.save(jpaEntity);
        return toDomainEntity(saved);
    }

    @Override
    public Optional<Articulo> findById(Long articuloId) {
        return jpaRepository.findById(articuloId)
                .map(ArticuloPersistenceAdapter::toDomainEntity);
    }

    @Override
    public boolean existsById(Long articuloId) {
        return jpaRepository.existsById(articuloId);
    }

    @Override
    public List<Articulo> findAll() {
        return jpaRepository.findAll().stream()
                .map(ArticuloPersistenceAdapter::toDomainEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long articuloId) {
        jpaRepository.deleteById(articuloId);
    }
}