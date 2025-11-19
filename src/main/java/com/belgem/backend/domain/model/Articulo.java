package com.belgem.backend.domain.model;

public class Articulo {

    private Long articuloId;
    private String nombre;
    private Double precio;
    private Double dto;
    private Integer cantidad;

    // Constructor, Getters y Setters...
    public Long getArticuloId() { return articuloId; }
    public void setArticuloId(Long articuloId) { this.articuloId = articuloId; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public Double getPrecio() { return precio; }
    public void setPrecio(Double precio) { this.precio = precio; }
    public Double getDto() { return dto; }
    public void setDto(Double dto) { this.dto = dto; }
    public Integer getCantidad() { return cantidad; }
    public void setCantidad(Integer cantidad) { this.cantidad = cantidad; }
}