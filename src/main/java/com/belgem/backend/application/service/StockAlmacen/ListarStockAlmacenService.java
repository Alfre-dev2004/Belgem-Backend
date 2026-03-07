package com.belgem.backend.application.service.StockAlmacen;

import com.belgem.backend.domain.model.StockAlmacen;
import com.belgem.backend.domain.port.output.StockAlmacenRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListarStockAlmacenService {

    private final StockAlmacenRepositoryPort repository;

    public ListarStockAlmacenService(StockAlmacenRepositoryPort repository) {
        this.repository = repository;
    }

    public List<StockAlmacen> listarTodo() {
        return repository.findAll();
    }

    public List<StockAlmacen> listarPorArticulo(Long articuloId) {
        return repository.findAllByArticuloId(articuloId);
    }

    public List<StockAlmacen> listarPorAlmacen(Long almacenId) {
        return repository.findAllByAlmacenId(almacenId);
    }
}
