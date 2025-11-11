package com.belgem.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(schema = "belgem", name = "currencies")
public class Divisas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    // para Spring/JPA
    public Divisas() {
    }

    // este es para asegurarBasicas()
    public Divisas(String code, String name) {
        this.code = code;
        this.name = name;
    }

    // getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
