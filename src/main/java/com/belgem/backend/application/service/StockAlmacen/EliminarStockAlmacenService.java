package com.belgem.backend.application.service.StockAlmacen;

import com.belgem.backend.domain.port.output.StockAlmacenRepositoryPort;
import org.springframework.stereotype.Service;

@Service
public class EliminarStockAlmacenService {

    private final StockAlmacenRepositoryPort repository;

    public EliminarStockAlmacenService(StockAlmacenRepositoryPort repository) {
        this.repository = repository;
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
