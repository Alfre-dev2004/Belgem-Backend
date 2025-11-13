package com.belgem.backend.repository;

import com.belgem.backend.entity.Divisas;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DivisasRepository extends JpaRepository<Divisas, Long> {
    boolean existsByCode(String code);
    Optional<Divisas> findByCode(String code);
    void deleteByCode(String code);
}

