package com.belgem.backend.domain.model;

public class Proveedor {

    private final Long id;
    private final String nombre;
    private final String cif;
    private final String telefono;
    private final String email;
    private final String direccion;
    private final String ciudad;
    private final String pais;
    private final Boolean activo;

    public Proveedor(Long id,
                     String nombre,
                     String cif,
                     String telefono,
                     String email,
                     String direccion,
                     String ciudad,
                     String pais,
                     Boolean activo) {

        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }

        if (email != null && !email.isBlank() && !email.contains("@")) {
            throw new IllegalArgumentException("El email no es válido");
        }

        this.id = id;
        this.nombre = nombre;
        this.cif = cif;
        this.telefono = telefono;
        this.email = email;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.pais = pais;
        this.activo = activo != null ? activo : true;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCif() {
        return cif;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getPais() {
        return pais;
    }

    public Boolean getActivo() {
        return activo;
    }
}