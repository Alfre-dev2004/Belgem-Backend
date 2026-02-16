package com.belgem.backend.domain.port.input;

import com.belgem.backend.domain.model.StockAlmacen;

public interface ObtenerStockAlmacenPorArticuloYalmacen {
    StockAlmacen StockByAlmacenyArticulo(Long Articuloid, Long Almacenid);
}
