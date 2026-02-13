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
    private String nombre;

    @Column(nullable = false)
    private String situacion; // ACTIVO | INACTIVO

    @Column(name = "pvp_minimo")
    private Double pvpMinimo;

    @Column(name = "peso_kg")
    private Double pesoKg;

    @Column(name = "alto_cm")
    private Double altoCm;

    @Column(name = "ancho_cm")
    private Double anchoCm;

    @Column(name = "largo_cm")
    private Double largoCm;

    @Column(nullable = false)
    private Boolean vendible;

    // Constructor vacío obligatorio para JPA
    public ArticuloJpaEntity() {}

    // Constructor completo
    public ArticuloJpaEntity(
            Long id,
            String nombre,
            String situacion,
            Double pvpMinimo,
            Double pesoKg,
            Double altoCm,
            Double anchoCm,
            Double largoCm,
            Boolean vendible
    ) {
        this.id = id;
        this.nombre = nombre;
        this.situacion = situacion;
        this.pvpMinimo = pvpMinimo;
        this.pesoKg = pesoKg;
        this.altoCm = altoCm;
        this.anchoCm = anchoCm;
        this.largoCm = largoCm;
        this.vendible = vendible;
    }

    // Getters y setters (JPA los necesita)

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSituacion() {
        return situacion;
    }

    public void setSituacion(String situacion) {
        this.situacion = situacion;
    }

    public Double getPvpMinimo() {
        return pvpMinimo;
    }

    public void setPvpMinimo(Double pvpMinimo) {
        this.pvpMinimo = pvpMinimo;
    }

    public Double getPesoKg() {
        return pesoKg;
    }

    public void setPesoKg(Double pesoKg) {
        this.pesoKg = pesoKg;
    }

    public Double getAltoCm() {
        return altoCm;
    }

    public void setAltoCm(Double altoCm) {
        this.altoCm = altoCm;
    }

    public Double getAnchoCm() {
        return anchoCm;
    }

    public void setAnchoCm(Double anchoCm) {
        this.anchoCm = anchoCm;
    }

    public Double getLargoCm() {
        return largoCm;
    }

    public void setLargoCm(Double largoCm) {
        this.largoCm = largoCm;
    }

    public Boolean getVendible() {
        return vendible;
    }

    public void setVendible(Boolean vendible) {
        this.vendible = vendible;
    }
}