package com.belgem.backend.infrastructure.adapter.output.persistence.jpa;

import jakarta.persistence.*;

@Entity
@Table(schema = "belgem", name = "representantes")
public class RepresentanteJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_representante")
    private Long idRepresentante;

    @Column(name = "nombre")
    private String nombre;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "email")
    private String email;
    @Column(name = "zona")
    private String zona;
    @Column(name = "codigointerno")
    private String codigoInterno;
    @Column(name = "comision")
    private Double comision;

    public RepresentanteJpaEntity() {}

    // Getters y Setters...
    public Long getIdRepresentante() { return idRepresentante; }
    public void setIdRepresentante(Long idRepresentante) { this.idRepresentante = idRepresentante; }
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