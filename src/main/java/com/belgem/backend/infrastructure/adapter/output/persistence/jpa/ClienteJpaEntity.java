package com.belgem.backend.infrastructure.adapter.output.persistence.jpa;

import jakarta.persistence.*;

/**
 *  Entidad JPA que representa la tabla "cliente" en la base de datos.
 *  Su función es mapear columnas SQL ↔ atributos de la entidad.
 */
@Entity
@Table(schema = "belgem", name = "cliente")
public class ClienteJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
    private String observaciones;

    public ClienteJpaEntity() {}

    public ClienteJpaEntity(String nombre, String nif, String direccion, String ciudad,
                            String codigoPostal, String telefono, String email,
                            String tipoCliente, String zona, String representante,
                            String observaciones) {

        this.nombre = nombre;
        this.nif = nif;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.codigoPostal = codigoPostal;
        this.telefono = telefono;
        this.email = email;
        this.tipoCliente = tipoCliente;
        this.zona = zona;
        this.representante = representante;
        this.observaciones = observaciones;
    }

    // ===== Getters y setters =====

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getNif() { return nif; }
    public void setNif(String nif) { this.nif = nif; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public String getCiudad() { return ciudad; }
    public void setCiudad(String ciudad) { this.ciudad = ciudad; }

    public String getCodigoPostal() { return codigoPostal; }
    public void setCodigoPostal(String codigoPostal) { this.codigoPostal = codigoPostal; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getTipoCliente() { return tipoCliente; }
    public void setTipoCliente(String tipoCliente) { this.tipoCliente = tipoCliente; }

    public String getZona() { return zona; }
    public void setZona(String zona) { this.zona = zona; }

    public String getRepresentante() { return representante; }
    public void setRepresentante(String representante) { this.representante = representante; }

    public String getObservaciones() { return observaciones; }
    public void setObservaciones(String observaciones) { this.observaciones = observaciones; }
}
