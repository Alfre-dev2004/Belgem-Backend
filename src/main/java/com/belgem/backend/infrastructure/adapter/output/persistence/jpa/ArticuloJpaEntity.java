package com.belgem.backend.infrastructure.adapter.output.persistence.jpa;

import jakarta.persistence.*;

@Entity
@Table(schema = "belgem", name = "articulos")
public class ArticuloJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "articulo")
    private Long articulo; // Columna real de la DB

    private String nombre;
    private Double precio;
    private Double dto;
    private Integer cantidad;

    public ArticuloJpaEntity() {}

    public Long getArticulo() { return articulo; }
    public void setArticulo(Long articulo) { this.articulo = articulo; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public Double getPrecio() { return precio; }
    public void setPrecio(Double precio) { this.precio = precio; }
    public Double getDto() { return dto; }
    public void setDto(Double dto) { this.dto = dto; }
    public Integer getCantidad() { return cantidad; }
    public void setCantidad(Integer cantidad) { this.cantidad = cantidad; }
}