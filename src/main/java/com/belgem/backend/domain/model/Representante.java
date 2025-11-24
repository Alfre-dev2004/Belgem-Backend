package com.belgem.backend.domain.model;

/**
 * Modelo de dominio para un Representante.
 * - No tiene JPA
 * - Es inmutable
 * - Solo lógica de negocio
 */
public class Representante {

    private final long id;
    private final String name;
    private final String phone;
    private final String email;
    private final String zone;
    private final String internalCode;
    private final long commission;

    public Representante(
            Long id,
            String name,
            String phone,
            String email,
            String zone,
            String internalCode,
            long commission
    ) {

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo o estar vacío");
        }

        if (phone == null || phone.isBlank()) {
            throw new IllegalArgumentException("El teléfono no puede ser nulo o estar vacío");
        }

        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("El email no puede ser nulo o estar vacío");
        }

        if (zone == null || zone.isBlank()) {
            throw new IllegalArgumentException("La zona no puede ser nula o estar vacía");
        }

        if (internalCode == null || internalCode.isBlank()) {
            throw new IllegalArgumentException("El código interno no puede ser nulo o estar vacío");
        }

        if (commission < 0) {
            throw new IllegalArgumentException("La comisión no puede ser negativa");
        }

        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.zone = zone;
        this.internalCode = internalCode;
        this.commission = commission;
    }

    // -------- Getters (clase inmutable) -------- //

    public long getId() { return id; }

    public String getName() { return name; }

    public String getPhone() { return phone; }

    public String getEmail() { return email; }

    public String getZone() { return zone; }

    public String getInternalCode() { return internalCode; }

    public long getCommission() { return commission; }
}
