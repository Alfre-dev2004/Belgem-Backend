package com.belgem.backend.application.service.StockAlmacen;

import com.belgem.backend.domain.model.StockAlmacen;
import com.belgem.backend.domain.port.output.StockAlmacenRepositoryPort;
import org.springframework.stereotype.Service;

@Service
public class ObtenerStockAlmacenPorIdService {

    private final StockAlmacenRepositoryPort repository;

    public ObtenerStockAlmacenPorIdService(StockAlmacenRepositoryPort repository) {
        this.repository = repository;
    }

    public StockAlmacen obtenerPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("StockAlmacen no encontrado con id=" + id));
    }
}
