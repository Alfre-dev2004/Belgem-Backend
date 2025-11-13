package com.belgem.backend.entity;

import jakarta.persistence.*;

// Indica que esta clase es una entidad de JPA (se corresponde con una tabla de la base de datos)
@Entity
// Define la tabla a la que se mapeará esta entidad, con esquema y nombre de tabla
@Table(schema = "belgem", name = "articulos")
public class Articulo {

    // Indica que este campo es la clave primaria de la tabla
    @Id
    // Indica que el valor de la clave primaria se genera automáticamente (auto_increment)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long articulo;

    // Campo que almacenará el nombre del artículo
    private String nombre;

    // Campo que almacenará el precio del artículo
    private Double precio;

    // Campo que almacenará el descuento aplicado al artículo
    private Double dto;

    // Campo que almacenará la cantidad disponible del artículo
    private Integer cantidad;

    // Getter y Setter de la clave primaria
    public Long getArticulo() {
        return articulo;
    }

    public void setArticulo(Long articulo) {
        this.articulo = articulo;
    }

    // Getter y Setter del nombre
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Getter y Setter del precio
    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    // Getter y Setter del descuento
    public Double getDto() {
        return dto;
    }

    public void setDto(Double dto) {
        this.dto = dto;
    }

    // Getter y Setter de la cantidad
    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
}