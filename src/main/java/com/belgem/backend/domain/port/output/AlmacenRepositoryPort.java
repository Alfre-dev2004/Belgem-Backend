package com.belgem.backend.domain.port.output;
/**
 * Puerto de salida para las operaciones de persistencia del módulo Almacén.
 *
 * Define las operacines que la capa de infraestructura debe implementar
 * sin exponer detalles de JPA ni tecnología externa.
 *
 * Parte fundamental de la arquitectura hexagonal, permitiendo la independencia
 * del dominio respecto a la infraestructura.
 */

import com.belgem.backend.domain.model.Almacen;
import java.util.List;
import java.util.Optional;

public interface AlmacenRepositoryPort {

    Almacen save(Almacen almacen);

    List<Almacen> findAll();

    Optional<Almacen> findById(Long id);

    boolean existsById(Long id);

    void deleteById(Long id);
}
