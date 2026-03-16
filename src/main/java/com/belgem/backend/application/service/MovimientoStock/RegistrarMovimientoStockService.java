package com.belgem.backend.application.service.MovimientoStock;

import com.belgem.backend.domain.model.MovimientoStock;
import com.belgem.backend.domain.model.StockAlmacen;
import com.belgem.backend.domain.model.TipoMovimiento;
import com.belgem.backend.domain.port.output.MovimientoStockRepositoryPort;
import com.belgem.backend.domain.port.output.StockAlmacenRepositoryPort;
import com.belgem.backend.domain.port.output.TipoMovimientoRepositoryPort;
import org.springframework.stereotype.Service;

@Service
public class RegistrarMovimientoStockService {

    private final MovimientoStockRepositoryPort movimientoRepository;
    private final StockAlmacenRepositoryPort stockRepository;
    private final TipoMovimientoRepositoryPort tipoMovimientoRepository;

    public RegistrarMovimientoStockService(MovimientoStockRepositoryPort movimientoRepository,
                                           StockAlmacenRepositoryPort stockRepository,
                                           TipoMovimientoRepositoryPort tipoMovimientoRepository) {
        this.movimientoRepository = movimientoRepository;
        this.stockRepository = stockRepository;
        this.tipoMovimientoRepository = tipoMovimientoRepository;
    }

    public MovimientoStock registrar(MovimientoStock movimientoStock) {

        TipoMovimiento tipoMovimiento = tipoMovimientoRepository.findById(movimientoStock.getTipoMovimientoId())
                .orElseThrow(() -> new IllegalArgumentException("TipoMovimiento no encontrado"));

        StockAlmacen stock = stockRepository
                .findByArticuloIdAndAlmacenId(movimientoStock.getArticuloId(), movimientoStock.getAlmacenId())
                .orElse(new StockAlmacen(
                        null,
                        movimientoStock.getArticuloId(),
                        movimientoStock.getAlmacenId(),
                        0
                ));

        int nuevoStock = stock.getStockActual() + (movimientoStock.getCantidad() * tipoMovimiento.getSigno());

        if (nuevoStock < 0) {
            throw new IllegalArgumentException("No se puede dejar el stock en negativo");
        }

        StockAlmacen stockActualizado = new StockAlmacen(
                stock.getId(),
                stock.getArticuloId(),
                stock.getAlmacenId(),
                nuevoStock
        );

        stockRepository.save(stockActualizado);

        return movimientoRepository.save(movimientoStock);
    }
}