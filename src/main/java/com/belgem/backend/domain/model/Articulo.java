package com.belgem.backend.domain.model;

public class Articulo {
    private final Long id;
    private final Integer cantidad;
    private final Double dto;
    private final String nombre;
    private final Double precio;

    public Articulo(Long id, Integer cantidad, Double dto, String nombre, Double precio) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }

        if (precio == null || precio < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo");
        }

        if (cantidad == null || cantidad < 0) {
            throw new IllegalArgumentException("El stock no puede ser negativo");
        }

        if (dto != null && (dto < 0 || dto > 100)) {
            throw new IllegalArgumentException("El descuento debe ser entre 0 y 100");
        }
        this.id = id;
        this.cantidad = cantidad;
        this.dto = dto;
        this.nombre = nombre;
        this.precio = precio;
    }

    public Long getId() {
        return id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public Double getDto() {
        return dto;
    }

    public String getNombre() {
        return nombre;
    }

    public Double getPrecio() {
        return precio;
    }
}
