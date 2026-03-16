package com.belgem.backend.application.service.MovimientoStock;

import com.belgem.backend.domain.model.MovimientoStock;
import com.belgem.backend.domain.port.output.MovimientoStockRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListarMovimientoStockService {

    private final MovimientoStockRepositoryPort repository;

    public ListarMovimientoStockService(MovimientoStockRepositoryPort repository) {
        this.repository = repository;
    }

    public List<MovimientoStock> listarTodos() {
        return repository.findAll();
    }

    public List<MovimientoStock> listarPorArticulo(Long articuloId) {
        return repository.findAllByArticuloId(articuloId);
    }

    public List<MovimientoStock> listarPorAlmacen(Long almacenId) {
        return repository.findAllByAlmacenId(almacenId);
    }
}