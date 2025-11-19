package com.belgem.backend.domain.model;

// NO hay imports de jakarta.persistence.
// NO hay anotaciones @Entity, @Table, @Id, @Column, @ManyToOne.
public class Cliente {

    private Long clienteId; // NOMBRE ESTANDARIZADO

    // Campos del CRUD original
    private String nombre;
    private String email;
    private String telefono;

    // Campos inferidos del método actualizar
    private String nif;
    private String direccion;
    private String ciudad;
    private String codigoPostal;
    private String tipoCliente; // o relación
    private String zona; // o relación
    private String observaciones;

    // Relación con Representante (el POJO de Dominio)
    private Representante representante;

    // Constructor, Getters y Setters...

    // Getters y Setters de la clave primaria
    public Long getClienteId() { return clienteId; }
    public void setClienteId(Long clienteId) { this.clienteId = clienteId; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    // Getters y Setters de campos inferidos
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
    public Representante getRepresentante() { return representante; }
    public void setRepresentante(Representante representante) { this.representante = representante; }
    public String getObservaciones() { return observaciones; }
    public void setObservaciones(String observaciones) { this.observaciones = observaciones; }
}