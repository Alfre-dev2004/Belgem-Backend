package com.belgem.backend.application.dto.tipoMovimiento;
/**
 * DTO para actualizar un TipoMovimiento.
 */
public class ActualizarTipoMovimientoRequest {

    private String nombre;
    private String descripcion;
    private Integer signo;
    //sin id porque lo crea la base de datos


    public ActualizarTipoMovimientoRequest() {}

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public Integer getSigno() {return signo;}
    public void setSigno(Integer signo) {this.signo = signo;}
}
