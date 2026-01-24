package com.belgem.backend.infrastructure.adapter.output.persistence.jpa;


import com.belgem.backend.domain.model.TipoMovimiento;
import com.belgem.backend.domain.port.output.TipoMovimientoRepositoryPort;
import com.belgem.backend.infrastructure.mapper.TipoMovimientoMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
/**
 * Adaptador de persistencia para el repositorio de TipoMovimiento.
 * <p>
 * Esta clase implementa el puerto de salida {@link TipoMovimientoRepositoryPort}
 * y se encarga de la interacción con la base de datos para las operaciones
 * relacionadas con los tipos de movimiento.
 * </p>
 */
@Component
public class TipoMovimientoPersistenceAdapter implements TipoMovimientoRepositoryPort {
    private final TipoMovimientoJpaRepository jpaRepository;

    public TipoMovimientoPersistenceAdapter(TipoMovimientoJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public TipoMovimiento save(TipoMovimiento tipoMovimiento){
        var saved = jpaRepository.save(TipoMovimientoMapper.toEntity(tipoMovimiento));
        return TipoMovimientoMapper.toDomain(saved);
    }


    @Override
    public Optional<TipoMovimiento> findById(Long id) {
        return jpaRepository.findById(id).map(TipoMovimientoMapper::toDomain);
    }

    @Override
    public List<TipoMovimiento> findAll() {
        return jpaRepository.findAll().stream().map(TipoMovimientoMapper::toDomain).toList();
    }

    @Override
    public boolean existsById(Long id) {
        return jpaRepository.existsById(id);
    }

    @Override
    public boolean existsByNombre(String nombre) {
        return jpaRepository.existsByNombre(nombre);
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }
}
