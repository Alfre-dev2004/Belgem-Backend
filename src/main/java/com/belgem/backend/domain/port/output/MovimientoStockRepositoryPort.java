package com.belgem.backend.domain.port.output;

import com.belgem.backend.domain.model.MovimientoStock;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface MovimientoStockRepositoryPort {
    MovimientoStock save(MovimientoStock movimientoStock);
    Optional<MovimientoStock> findById(Long id);
    List<MovimientoStock> findAll();
    List<MovimientoStock> findAllByArticuloId(Long articuloId);
    List<MovimientoStock> findAllByAlmacenId(Long almacenId);
}
