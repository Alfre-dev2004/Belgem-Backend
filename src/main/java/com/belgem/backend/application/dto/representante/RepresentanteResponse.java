package com.belgem.backend.application.dto.representante;

public class RepresentanteResponse {

    private Long id;
    private String name;
    private String phone;
    private String email;
    private String zone;
    private String internalCode;
    private Long commission;

    public RepresentanteResponse(Long id, String name, String phone, String email, String zone, String internalCode, Long commission) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.zone = zone;
        this.internalCode = internalCode;
        this.commission = commission;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getPhone() { return phone; }
    public String getEmail() { return email; }
    public String getZone() { return zone; }
    public String getInternalCode() { return internalCode; }
    public Long getCommission() { return commission; }

}
