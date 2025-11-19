package com.belgem.backend.domain.port.output;

import com.belgem.backend.domain.model.Representante;
import java.util.List;
import java.util.Optional;

public interface RepresentanteRepositoryPort {
    Representante save(Representante representante);
    Optional<Representante> findById(Long representanteId);
    boolean existsById(Long representanteId);
    List<Representante> findAll();
    void deleteById(Long representanteId);

    // Métodos específicos
    Optional<Representante> findByEmail(String email);
    boolean existsByEmail(String email);
}