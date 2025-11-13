package com.belgem.backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

/**
 * Entidad que representa la tabla 'cliente' en la base de datos (schema v1).
 *
 * Contiene los datos principales del cliente y se utiliza para mapear
 * los registros de la tabla 'v1.cliente' mediante JPA/Hibernate.
 */
@Entity
@Table(name = "cliente", schema = "belgem")
public class Cliente {

    /**
     * Identificador único del cliente (clave primaria).
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long idCliente;

    /**
     * Nombre completo del cliente.
     * Este campo es obligatorio (no puede estar vacío).
     */
    @NotBlank
    private String nombre;
    private String nif;
    private String direccion;
    private String ciudad;
    private String codigoPostal;
    private String telefono;
    private String email;
    private String tipoCliente;
    private String zona;
    private String representante;

    /** Observaciones adicionales o notas relevantes. */
    @Column(columnDefinition = "TEXT")
    private String observaciones;

    // ----------------- Getters y Setters -----------------
    public Long getIdCliente() {
        return idCliente;
    }
    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNif() {
        return nif;
    }
    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }
    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }
    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public String getZona() {
        return zona;
    }
    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getRepresentante() {
        return representante;
    }
    public void setRepresentante(String representante) {
        this.representante = representante;
    }

    public String getObservaciones() {
        return observaciones;
    }
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}
