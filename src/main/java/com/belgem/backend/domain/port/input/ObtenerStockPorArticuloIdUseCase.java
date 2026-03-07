package com.belgem.backend.domain.port.input;

import com.belgem.backend.domain.model.StockAlmacen;

public interface ObtenerStockPorArticuloIdUseCase {
    StockAlmacen ObtenerPorArticuloId(Long ArticuloId);
}
