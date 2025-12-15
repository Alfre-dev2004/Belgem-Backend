package com.belgem.backend.domain.model;

/**
 * Entidad de dominio que representa un tipo de movimiento de almacén.
 *
 * Ejemplos: Entrada, Salida, Ajuste, Devolución.
 */
public class TipoMovimiento {

    private Long id;
    private String nombre;
    private String descripcion;

    /**
    constructor vacío para frameworks/mappers cuando sea necesario.
     */
public TipoMovimiento(){}

    /**
     * Crea un {@link TipoMovimiento} con sus datos principales.
     *
     * @param id Identificador único del tipo de movimiento.
     * @param nombre Nombre del tipo de movimiento. (ej. "Entrada", "Salida").
     * @param descripcion Descripción funcional detallada del tipo de movimiento.
     */

    public TipoMovimiento(Long id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    /** @return id del tipo de movimiento */
    public Long getId() { return id; }

    /** @param id id del tipo de movimiento */
    public void setId(Long id) { this.id = id; }

    /** @return nombre del tipo */
    public String getNombre() { return nombre; }

    /** @param nombre nombre del tipo */
    public void setNombre(String nombre) { this.nombre = nombre; }

    /** @return descripción del tipo */
    public String getDescripcion() { return descripcion; }

    /** @param descripcion descripción del tipo */
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
}