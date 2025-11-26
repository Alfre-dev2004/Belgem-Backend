package com.belgem.backend.domain.port.output;

import com.belgem.backend.domain.model.Divisa;
import java.util.List;
import java.util.Optional;
/**
 * Puerto de salida para las operaciones de persistencia relacionadas con las divisas.
 */
public interface DivisaRepositoryPort {

    Divisa save(Divisa divisa);

    Optional<Divisa> findById(Long id);

    List<Divisa> findAll();

    void deleteById(Long id);

    boolean existsByCode(String code);
}
