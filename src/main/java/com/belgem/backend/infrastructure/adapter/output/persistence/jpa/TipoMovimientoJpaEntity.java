package com.belgem.backend.infrastructure.adapter.output.persistence.jpa;


import jakarta.persistence.*;

/**
 * Entidad JPA para persistir el catálogo de tipos de movimiento en la base de datos.
 */

@Entity
@Table(name = "tipo_movimiento", schema = "belgem")
public class TipoMovimientoJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 60)
    private String nombre;

    @Column(length = 255)
    private String descripcion;

    @Column(nullable = false)
    private Integer signo;

    public TipoMovimientoJpaEntity() {}

    public TipoMovimientoJpaEntity(Long id, String nombre, String descripcion, Integer signo) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.signo = signo;
    }


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public Integer getSigno() { return signo; }
    public void setSigno(Integer signo) { this.signo = signo; }

}
