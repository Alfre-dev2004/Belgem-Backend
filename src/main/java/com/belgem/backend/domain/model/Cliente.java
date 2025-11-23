package com.belgem.backend.domain.model;

/**
 * Modelo de dominio que representa un Cliente dentro del núcleo de negocio.
 */
public class Cliente {

    private final Long id;
    private final String nombre;
    private final String nif;
    private final String direccion;
    private final String ciudad;
    private final String codigoPostal;
    private final String telefono;
    private final String email;
    private final String tipoCliente;
    private final String zona;
    private final String representante;
    private final String observaciones;


    /**
     * Constructor principal del dominio.
     *
     * Aquí colocamos validaciones de negocio ligeras:
     *  - Nombre no puede estar vacío.
     *  - Email debe contener '@' si no está vacío.
     *
     * Estas reglas pertenecen estrictamente al dominio.
     */
    public Cliente(Long id,
                   String nombre,
                   String nif,
                   String direccion,
                   String ciudad,
                   String codigoPostal,
                   String telefono,
                   String email,
                   String tipoCliente,
                   String zona,
                   String representante,
                   String observaciones) {

        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        if (email != null && !email.isBlank() && !email.contains("@")) {
            throw new IllegalArgumentException("Email inválido");
        }

    // Inmutabilidad → solo asignación en constructor
        this.id = id;
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

    // ==== Getters (sin setters para mantener el dominio inmutable) ====
    public Long getId() { return id; }
    public String getNombre() { return nombre; }
    public String getNif() { return nif; }
    public String getDireccion() { return direccion; }
    public String getCiudad() { return ciudad; }
    public String getCodigoPostal() { return codigoPostal; }
    public String getTelefono() { return telefono; }
    public String getEmail() { return email; }
    public String getTipoCliente() { return tipoCliente; }
    public String getZona() { return zona; }
    public String getRepresentante() { return representante; }
    public String getObservaciones() { return observaciones; }
}

