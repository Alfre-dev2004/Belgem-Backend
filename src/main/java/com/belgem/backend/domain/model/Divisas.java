package com.belgem.backend.domain.model; // PAQUETE ACTUALIZADO

import jakarta.persistence.*;

@Entity
@Table(schema = "belgem", name = "currencies")
public class Divisas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") // Mapea a la columna real 'id'
    private Long divisaId; // NOMBRE ESTANDARIZADO

    @Column(name = "code", nullable = false)
    private String code;

    @Column(name = "name", nullable = false)
    private String name;

    public Divisas() {}
    public Divisas(String code, String name) { this.code = code; this.name = name; }


    public Long getDivisaId() { return divisaId; }
    public void setDivisaId(Long divisaId) { this.divisaId = divisaId; }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}