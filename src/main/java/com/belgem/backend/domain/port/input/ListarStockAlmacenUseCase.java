package com.belgem.backend.domain.port.input;

import com.belgem.backend.domain.model.StockAlmacen;

import java.util.List;

public interface ListarStockAlmacenUseCase {
    List<StockAlmacen> listarStockAlmacen();
}
