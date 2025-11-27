package com.belgem.backend.application.dto.divisa;

import jakarta.validation.constraints.NotBlank;

public class CrearDivisaRequest {

    private String code;
    private String name;

    // Constructor vacío → Jackson lo necesita
    public CrearDivisaRequest() {}

    // Constructor completo → útil para tests
    public CrearDivisaRequest(String code, String name) {
        this.code = code;
        this.name = name;
    }

    // Getters
    public String getCode() { return code; }
    public String getName() { return name; }

    // Setters
    public void setCode(String code) { this.code = code; }
    public void setName(String name) { this.name = name; }

    @Override
    public String toString() {
        return "CrearDivisaRequest{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
