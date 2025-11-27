package com.belgem.backend.infrastructure.adapter.output.persistence.jpa;

import jakarta.persistence.*;

@Entity
@Table(schema = "belgem", name = "currencies")
public class DivisaJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "code", nullable = false)
    private String code;

    @Column(name = "name", nullable = false)
    private String name;

    // Constructor vacío para JPA (OBLIGATORIO)
    public DivisaJpaEntity() {}

    // Constructor para crear (sin id)
    public DivisaJpaEntity(String code, String name) {
        this.code = code;
        this.name = name;
    }

    // Constructor para actualizar o mapear desde dominio (con id)
    public DivisaJpaEntity(Long id, String code, String name) {
        this.id = id;
        this.code = code;
        this.name = name;
    }


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
