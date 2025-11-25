package com.belgem.backend.application.dto.representante;

/**
 * DTO utilizado para recibir los datos necesarios para actualizar un representante.
 *
 * Este objeto define la **estructura del JSON** enviado desde el frontend
 * al realizar la petición: **PUT /representantes/{id}**.
 *
 * Importante:
 *  - Es un DTO de entrada, solo transporta datos.
 *  - No contiene lógica de negocio.
 *  - No debe incluir validaciones ni anotaciones.
 */
public class ActualizarRepresentanteRequest {

    private String name;
    private String phone;
    private String email;
    private String zone;
    private String internalCode;
    private Long commission;

    public ActualizarRepresentanteRequest(String name, String phone, String email, String zone, String internalCode, Long commission) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.zone = zone;
        this.internalCode = internalCode;
        this.commission = commission;
    }

    public String getName() { return name; }
    public String getPhone() { return phone; }
    public String getEmail() { return email; }
    public String getZone() { return zone; }
    public String getInternalCode() { return internalCode; }
    public Long getCommission() { return commission; }

}
