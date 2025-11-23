package com.belgem.backend.application.dto.divisa;

import jakarta.validation.constraints.NotBlank;

// No tiene ID porque viene en la URL
public class ActualizarDivisaRequest {

    @NotBlank(message = "El código no puede estar vacío")
    private String code;

    @NotBlank(message = "El nombre no puede estar vacío")
    private String name;

    public ActualizarDivisaRequest() {}

    public ActualizarDivisaRequest(String code, String name) {
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
        return "ActualizarDivisaRequest{code='" + code + "', name='" + name + "'}";
    }
}
