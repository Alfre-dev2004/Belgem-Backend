package com.belgem.backend.application.dto.representante;

/**
 * DTO utilizado para recibir los datos necesarios para crear un representante.
 *
 * Este objeto define la **estructura del JSON** enviado desde el frontend
 * al realizar la petición: **POST /representantes**.
 *
 * Importante:
 *  - Es un DTO de entrada, únicamente transporta datos.
 *  - No contiene lógica de negocio.
 *  - No incluye validaciones ni anotaciones adicionales.
 */
public class CrearRepresentanteRequest {

    private String name;
    private String phone;
    private String email;
    private String zone;
    private String internalCode;
    private Long commission;

    /**
     * Crea una instancia del DTO con todos los datos obligatorios.
     */
    public CrearRepresentanteRequest(String name, String phone, String email, String zone, String internalCode, Long commission) {
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
