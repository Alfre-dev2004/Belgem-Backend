package com.belgem.backend.infrastructure.adapter.output.persistence.jpa;

import jakarta.persistence.*;

@Entity
@Table(
        name = "stock_almacen",schema = "belgem",
        uniqueConstraints = @UniqueConstraint(name = "uk_stock_articulo_almacen", columnNames = {"articulo_id", "almacen_id"})
)
public class StockAlmacenJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "articulo_id", nullable = false)
    private Long articuloId;

    @Column(name = "almacen_id", nullable = false)
    private Long almacenId;

    @Column(name = "stock_actual", nullable = false)
    private Integer stockActual;

    public StockAlmacenJpaEntity() {}

    public StockAlmacenJpaEntity(Long id, Long articuloId, Long almacenId, Integer stockActual) {
        this.id = id;
        this.articuloId = articuloId;
        this.almacenId = almacenId;
        this.stockActual = stockActual;
    }

    public Long getId() { return id; }
    public Long getArticuloId() { return articuloId; }
    public Long getAlmacenId() { return almacenId; }
    public Integer getStockActual() { return stockActual; }

    public void setId(Long id) { this.id = id; }
    public void setArticuloId(Long articuloId) { this.articuloId = articuloId; }
    public void setAlmacenId(Long almacenId) { this.almacenId = almacenId; }
    public void setStockActual(Integer stockActual) { this.stockActual = stockActual; }
}
