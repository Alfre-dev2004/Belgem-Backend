package com.belgem.backend.infrastructure.adapter.output.persistence.jpa;

import jakarta.persistence.*;

@Entity
@Table(name = "cliente")
public class ClienteJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id; // Columna real de la DB

    private String nombre;
    private String email;
    private String telefono;

    // Campos inferidos del método actualizar
    private String nif;
    private String direccion;
    private String ciudad;
    private String codigoPostal;
    private String tipoCliente;
    private String zona;
    private String observaciones;

    // Suponiendo que la relación de Representante ya está en la DB
    // @ManyToOne(fetch = FetchType.LAZY)
    // @JoinColumn(name = "id_representante")
    // private RepresentanteJpaEntity representante;

    public ClienteJpaEntity() {}

    // Getters y Setters...
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public String getNif() { return nif; }
    public void setNif(String nif) { this.nif = nif; }
    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    public String getCiudad() { return ciudad; }
    public void setCiudad(String ciudad) { this.ciudad = ciudad; }
    public String getCodigoPostal() { return codigoPostal; }
    public void setCodigoPostal(String codigoPostal) { this.codigoPostal = codigoPostal; }
    public String getTipoCliente() { return tipoCliente; }
    public void setTipoCliente(String tipoCliente) { this.tipoCliente = tipoCliente; }
    public String getZona() { return zona; }
    public void setZona(String zona) { this.zona = zona; }
    public String getObservaciones() { return observaciones; }
    public void setObservaciones(String observaciones) { this.observaciones = observaciones; }
}