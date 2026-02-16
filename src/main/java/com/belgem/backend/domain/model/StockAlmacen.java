package com.belgem.backend.domain.model;

public class StockAlmacen {
    private final Long id;
    private final Long articuloId;
    private final Long almacenId;
    private final Integer stockActual;

    public StockAlmacen(Long id, Long articuloId, Long almacenId, Integer stockActual) {
        if (articuloId == null){
            throw new IllegalArgumentException("Articulo id cannot be null");
        }
        if (almacenId == null){
            throw new IllegalArgumentException("Almacen id cannot be null");
        }
        if  (stockActual <0){
            throw new IllegalArgumentException("Stock cant be less than 0");
        }
        this.id = id;
        this.articuloId = articuloId;
        this.almacenId = almacenId;
        this.stockActual = stockActual;
    }


    public Long getId() {
        return id;
    }

    public Long getArticuloId() {
        return articuloId;
    }

    public Long getAlmacenId() {
        return almacenId;
    }

    public Integer getStockActual() {
        return stockActual;
    }
}
