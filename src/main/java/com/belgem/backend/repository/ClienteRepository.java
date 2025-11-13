package com.belgem.backend.repository;

import com.belgem.backend.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio JPA para la entidad {@link Cliente}.
 *
 * Gestiona las operaciones CRUD (crear, leer, actualizar, eliminar)
 * automáticamente mediante Spring Data JPA.
 *
 * Se comunica con la base de datos Supabase definida en application.properties.
 */
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
