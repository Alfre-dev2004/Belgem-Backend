package com.belgem.backend.domain.port.output;

import com.belgem.backend.domain.model.Representante;
import java.util.List;
import java.util.Optional;

public interface RepresentanteRepositoryPort {

    Representante save(Representante representante);

    Optional<Representante> findById(Long id);

    List<Representante> findAll();

    boolean existsById(Long id);

    void deleteById(Long id);
}
