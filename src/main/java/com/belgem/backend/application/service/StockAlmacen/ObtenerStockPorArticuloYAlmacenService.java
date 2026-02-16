package com.belgem.backend.application.service.StockAlmacen;

import com.belgem.backend.domain.model.StockAlmacen;
import com.belgem.backend.domain.port.output.StockAlmacenRepositoryPort;
import org.springframework.stereotype.Service;

@Service
public class ObtenerStockPorArticuloYAlmacenService {

    private final StockAlmacenRepositoryPort repository;

    public ObtenerStockPorArticuloYAlmacenService(StockAlmacenRepositoryPort repository) {
        this.repository = repository;
    }

    public StockAlmacen obtener(Long articuloId, Long almacenId) {
        return repository.findByArticuloIdAndAlmacenId(articuloId, almacenId)
                .orElseThrow(() -> new IllegalArgumentException(
                        "StockAlmacen no encontrado para articuloId=" + articuloId + " almacenId=" + almacenId
                ));
    }
}
