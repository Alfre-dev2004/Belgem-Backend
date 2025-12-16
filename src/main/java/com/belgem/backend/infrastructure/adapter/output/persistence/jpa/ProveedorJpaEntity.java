package com.belgem.backend.infrastructure.adapter.output.persistence.jpa;

import jakarta.persistence.*;

/**
 * Entidad JPA que representa la tabla {@code proveedores} en la base de datos.
 * <p>
 * Esta clase pertenece exclusivamente a la capa de infraestructura.
 * El dominio trabaja con {@link com.belgem.backend.domain.model.Proveedor}.
 * </p>
 */
@Entity
@Table(schema = "belgem", name = "proveedores")
public class ProveedorJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    private String cif;

    private String telefono;

    private String email;

    private String direccion;

    private String ciudad;

    private String pais;

    @Column(nullable = false)
    private Boolean activo;

    // Constructor vacío obligatorio para JPA
    public ProveedorJpaEntity() {
    }

    // Constructor completo
    public ProveedorJpaEntity(Long id,
                              String nombre,
                              String cif,
                              String telefono,
                              String email,
                              String direccion,
                              String ciudad,
                              String pais,
                              Boolean activo) {
        this.id = id;
        this.nombre = nombre;
        this.cif = cif;
        this.telefono = telefono;
        this.email = email;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.pais = pais;
        this.activo = activo;
    }

    // Getters y setters (JPA los necesita)

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

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
}

