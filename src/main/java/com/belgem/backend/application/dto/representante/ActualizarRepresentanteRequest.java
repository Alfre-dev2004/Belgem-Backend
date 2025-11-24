package com.belgem.backend.application.dto.representante;

public class ActualizarRepresentanteRequest {

    private String name;
    private String phone;
    private String email;
    private String zone;
    private String internalCode;
    private Long commission;

    public ActualizarRepresentanteRequest() {}

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

    public void setName(String name) { this.name = name; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setEmail(String email) { this.email = email; }
    public void setZone(String zone) { this.zone = zone; }
    public void setInternalCode(String internalCode) { this.internalCode = internalCode; }
    public void setCommission(Long commission) { this.commission = commission; }
}
