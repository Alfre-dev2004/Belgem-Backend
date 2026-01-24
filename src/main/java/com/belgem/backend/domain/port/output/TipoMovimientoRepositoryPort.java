package com.belgem.backend.domain.port.output;
import com.belgem.backend.domain.model.TipoMovimiento;

import java.util.List;
import java.util.Optional;

/**
 * Puerto de salida para operaciones de persistencia de {@link TipoMovimiento}.
 *
 * Define el contrato que la infraestructura debe implementar.
 */
public interface TipoMovimientoRepositoryPort {

    TipoMovimiento save(TipoMovimiento tipoMovimiento);

    Optional<TipoMovimiento> findById(Long id);

    List<TipoMovimiento> findAll();

    boolean existsById(Long id);

    boolean existsByNombre(String nombre);

    void deleteById(Long id);
}
