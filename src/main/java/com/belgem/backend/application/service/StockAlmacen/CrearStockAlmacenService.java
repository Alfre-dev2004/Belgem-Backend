package com.belgem.backend.application.service.StockAlmacen;

import com.belgem.backend.domain.model.StockAlmacen;
import com.belgem.backend.domain.port.output.StockAlmacenRepositoryPort;
import org.springframework.stereotype.Service;

@Service
public class CrearStockAlmacenService {

    private final StockAlmacenRepositoryPort repository;

    public CrearStockAlmacenService(StockAlmacenRepositoryPort repository) {
        this.repository = repository;
    }

    public StockAlmacen crear(StockAlmacen stockAlmacen) {
        return repository.save(stockAlmacen);
    }
}
