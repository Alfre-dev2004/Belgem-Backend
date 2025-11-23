package com.belgem.backend.application.dto.divisa;

// Representa lo que el backend devuelve al cliente
public class DivisaResponse {

    private Long id;
    private String code;
    private String name;

    // Constructor vacío
    public DivisaResponse() {}

    // Constructor completo
    public DivisaResponse(Long id, String code, String name) {
        this.id = id;
        this.code = code;
        this.name = name;
    }

    // Getters
    public Long getId() { return id; }
    public String getCode() { return code; }
    public String getName() { return name; }

    // Setters
    public void setId(Long id) { this.id = id; }
    public void setCode(String code) { this.code = code; }
    public void setName(String name) { this.name = name; }

    @Override
    public String toString() {
        return "DivisaResponse{" +
                "id=" + id +'\''+
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
