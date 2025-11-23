package com.belgem.backend.infrastructure.adapter.output.persistence.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DivisaJpaRepository extends JpaRepository<DivisaJpaEntity, Long> {

    boolean existsByCode(String code);
}
