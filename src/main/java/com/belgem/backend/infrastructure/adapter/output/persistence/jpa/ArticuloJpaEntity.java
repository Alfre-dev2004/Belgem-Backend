package com.belgem.backend.infrastructure.adapter.output.persistence.jpa;

import jakarta.persistence.*;
/**
 * Entidad JPA que representa la tabla {@code articulos} en la base de datos.
 * <p>
 * Esta clase pertenece exclusivamente a la capa de infraestructura.
 * El dominio trabaja con {@link com.belgem.backend.domain.model.Articulo}.
 * </p>
 */
@Entity
@Table(schema = "belgem", name = "articulos")
public class ArticuloJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer cantidad;

    private Double dto;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private Double precio;

    // Constructor vacío obligatorio para JPA
    public ArticuloJpaEntity() {}

    // Constructor completo
    public ArticuloJpaEntity(Long id, Integer cantidad, Double dto, String nombre, Double precio) {
        this.id = id;
        this.cantidad = cantidad;
        this.dto = dto;
        this.nombre = nombre;
        this.precio = precio;
    }

    // Getters y setters (JPA los necesita)

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getDto() {
        return dto;
    }

    public void setDto(Double dto) {
        this.dto = dto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
}