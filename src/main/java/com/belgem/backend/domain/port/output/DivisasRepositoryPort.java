package com.belgem.backend.domain.port.output;

import com.belgem.backend.domain.model.Divisas;
import java.util.List;
import java.util.Optional;

public interface DivisasRepositoryPort {
    Divisas save(Divisas divisa);
    Optional<Divisas> findById(Long divisaId);
    boolean existsById(Long divisaId);
    List<Divisas> findAll();
    void deleteById(Long divisaId);

    // Métodos específicos
    boolean existsByCode(String code);
    Optional<Divisas> findByCode(String code);
    void deleteByCode(String code);
}