package com.belgem.backend.repository;

import com.belgem.backend.entity.Representante;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RepresentanteRepository extends JpaRepository<Representante, Long> {

    Optional<Representante> findByEmail(String email);

    boolean existsByEmail(String email);
}
