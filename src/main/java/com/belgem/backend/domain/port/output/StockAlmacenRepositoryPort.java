package com.belgem.backend.domain.port.output;
import com.belgem.backend.domain.model.StockAlmacen;

import java.util.List;
import java.util.Optional;

public interface StockAlmacenRepositoryPort {
    StockAlmacen save(StockAlmacen stockAlmacen);

    Optional<StockAlmacen> findById(Long id);

    Optional<StockAlmacen> findByArticuloIdAndAlmacenId(Long articuloId, Long almacenId);

    List<StockAlmacen> findAllByArticuloId(Long articuloId);

    List<StockAlmacen> findAllByAlmacenId(Long almacenId);

    List<StockAlmacen> findAll();

    void deleteById(Long id);
}
