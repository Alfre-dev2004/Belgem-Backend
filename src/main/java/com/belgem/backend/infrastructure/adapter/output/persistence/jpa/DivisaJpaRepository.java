package com.belgem.backend.infrastructure.adapter.output.persistence.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface DivisaJpaRepository extends JpaRepository<DivisaJpaEntity, Long> {

    boolean existsByCode(String code);

    Optional<DivisaJpaEntity> findByCode(String code);
}
