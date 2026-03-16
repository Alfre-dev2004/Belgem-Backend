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
    private Integer signo;

    /**
     * Constructor vacío para frameworks/mappers cuando sea necesario.
     */
    public TipoMovimiento() {}

    /**
     * Crea un TipoMovimiento con sus datos principales.
     *
     * @param id Identificador único del tipo de movimiento.
     * @param nombre Nombre del tipo de movimiento.
     * @param descripcion Descripción funcional del tipo de movimiento.
     * @param signo Indica si el movimiento suma o resta stock.
     *              1 = suma, -1 = resta
     */
    public TipoMovimiento(Long id, String nombre, String descripcion, Integer signo) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.signo = signo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getSigno() {
        return signo;
    }

    public void setSigno(Integer signo) {
        this.signo = signo;
    }
}