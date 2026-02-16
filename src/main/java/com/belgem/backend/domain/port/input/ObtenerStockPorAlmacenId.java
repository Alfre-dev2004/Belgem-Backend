package com.belgem.backend.domain.port.input;

import com.belgem.backend.domain.model.StockAlmacen;

public interface ObtenerStockPorAlmacenId {
        StockAlmacen ObtenerPorAlmacenId(Long AlmacenId);

}
