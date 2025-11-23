package com.belgem.backend.domain.model;
/** Clase que representa una divisa con su código y nombre.
 * No tiene JPA
 * Es inmutable
 * Solo lógica del negocio
  */
public class Divisa {

    private final Long id;
    private final String code;
    private final String name;

    public Divisa(Long id, String code, String name) {
        if (code == null || code.isBlank()) {
            throw new IllegalArgumentException("El código no puede estar vacío");
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }

        this.id = id;
        this.code = code;
        this.name = name;
    }

    /** Obtiene el ID de la divisa.
     * @return El ID de la divisa.
     No tiene setter porque es (casi) inmutable
     */
    public Long getId() { return id; }

    public String getCode() { return code; }

    public String getName() { return name; }
}

