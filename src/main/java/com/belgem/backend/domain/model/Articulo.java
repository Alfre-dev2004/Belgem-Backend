package com.belgem.backend.domain.model;

public class Articulo {

    private final Long id;
    private final String nombre;
    private final String situacion;
    private final Double pvpMinimo;
    private final Double pesoKg;
    private final Double altoCm;
    private final Double anchoCm;
    private final Double largoCm;
    private final Boolean vendible;

    public Articulo(
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

        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre es obligatorio");
        }

        if (situacion == null ||
                (!situacion.equals("ACTIVO") && !situacion.equals("INACTIVO"))) {
            throw new IllegalArgumentException("Situación inválida (ACTIVO | INACTIVO)");
        }

        if (pvpMinimo != null && pvpMinimo < 0) {
            throw new IllegalArgumentException("El PVP mínimo no puede ser negativo");
        }

        validarNoNegativo(pesoKg, "peso");
        validarNoNegativo(altoCm, "alto");
        validarNoNegativo(anchoCm, "ancho");
        validarNoNegativo(largoCm, "largo");

        this.id = id;
        this.nombre = nombre;
        this.situacion = situacion;
        this.pvpMinimo = pvpMinimo;
        this.pesoKg = pesoKg;
        this.altoCm = altoCm;
        this.anchoCm = anchoCm;
        this.largoCm = largoCm;
        this.vendible = vendible != null ? vendible : Boolean.TRUE;
    }

    private void validarNoNegativo(Double valor, String campo) {
        if (valor != null && valor < 0) {
            throw new IllegalArgumentException("El " + campo + " no puede ser negativo");
        }
    }

    public Long getId() { return id; }
    public String getNombre() { return nombre; }
    public String getSituacion() { return situacion; }
    public Double getPvpMinimo() { return pvpMinimo; }
    public Double getPesoKg() { return pesoKg; }
    public Double getAltoCm() { return altoCm; }
    public Double getAnchoCm() { return anchoCm; }
    public Double getLargoCm() { return largoCm; }
    public Boolean getVendible() { return vendible; }
}