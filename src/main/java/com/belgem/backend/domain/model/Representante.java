package com.belgem.backend.domain.model;

public class Representante {

    private Long representanteId;
    private String nombre;
    private String telefono;
    private String email;
    private String zona;
    private String codigoInterno;
    private Double comision;

    // Constructor vacío (obligatorio para JPA)
    public Representante() {}

    // Getters y Setters...
    public Long getRepresentanteId() { return representanteId; }
    public void setRepresentanteId(Long representanteId) { this.representanteId = representanteId; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getZona() { return zona; }
    public void setZona(String zona) { this.zona = zona; }
    public String getCodigoInterno() { return codigoInterno; }
    public void setCodigoInterno(String codigoInterno) { this.codigoInterno = codigoInterno; }
    public Double getComision() { return comision; }
    public void setComision(Double comision) { this.comision = comision; }
}