package com.belgem.backend.domain.model;
/**
 * Modelo de dominio que representa un Almacén dentro del núcleo de negoco.
 *
 *Este objeto es inmuutable y contiene únicamente datos relevantes para la lógica de negocio.
 * Toda validación básica se realiza en el constructor.
 *
 * Reglas:
 * - el nombre es obligatorio y no puede estar vacío.
 * - el dominio NO conoce JPA, DTOs ni tecnología externa.
 * */
public class Almacen {

    //atributos
    private final Long id;
    private final String nombre;
    private final String direccion;
    private final String telefono;
    private final String responsable;
    private final boolean activo;

    //constructor
    public Almacen(
            Long id,
            String nombre,
            String direccion,
            String telefono,
            String responsable,
            boolean activo
    ){
        if(nombre ==null || nombre.isEmpty()){
            throw new IllegalArgumentException("El nombre no puede ser nulo o vacío");
        }
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.responsable = responsable;
        this.activo = activo;
    }

    //getters/setters

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getResponsable() {
        return responsable;
    }

    public boolean isActivo() {
        return activo;
    }
}
