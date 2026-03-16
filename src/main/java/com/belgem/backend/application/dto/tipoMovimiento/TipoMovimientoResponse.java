package com.belgem.backend.application.dto.tipoMovimiento;
/**
 * DTO de salida para TipoMovimiento.
 */
public class TipoMovimientoResponse {

    private Long id;
    private String nombre;
    private String descripcion;
    private Integer signo;

    public TipoMovimientoResponse() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public Integer getSigno() { return signo; }
    public void setSigno(Integer signo) { this.signo = signo; }
}