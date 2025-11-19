package com.belgem.backend.domain.model;

public class Divisas {
    private Long divisaId;
    private String code;
    private String name;

    public Divisas() {}
    public Divisas(Long divisaId, String code, String name) {
        this.divisaId = divisaId;
        this.code = code;
        this.name = name;
    }
    // Constructor con code y name (para semilla)
    public Divisas(String code, String name) {
        this.code = code;
        this.name = name;
    }

    // Getters y Setters...
    public Long getDivisaId() { return divisaId; }
    public void setDivisaId(Long divisaId) { this.divisaId = divisaId; }
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}