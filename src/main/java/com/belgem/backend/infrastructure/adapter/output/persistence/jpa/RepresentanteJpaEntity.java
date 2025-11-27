package com.belgem.backend.infrastructure.adapter.output.persistence.jpa;

import jakarta.persistence.*;

/**
 * Entidad JPA para la persistencia de Representantes.
 * Representa la tabla "representantes" en la base de datos
 * y permite la interacción con JPA/Hibernate.
 */
@Entity
@Table(schema = "belgem", name = "representantes")
public class RepresentanteJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_representante")
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String name;

    @Column(name = "telefono", nullable = false)
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "zona", nullable = false)
    private String zone;

    @Column(name = "codigointerno", nullable = false)
    private String internalCode;

    @Column(name = "comision")
    private Long commission;

    // Constructor vacío requerido por JPA
    public RepresentanteJpaEntity() {}

    // Constructor sin ID, para crear nuevos representantes
    public RepresentanteJpaEntity(String name, String phone, String email,
                                  String zone, String internalCode, Long commission) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.zone = zone;
        this.internalCode = internalCode;
        this.commission = commission;
    }

    // Constructor completo con ID, para actualizar representantes existentes
    public RepresentanteJpaEntity(Long id, String name, String phone, String email,
                                  String zone, String internalCode, Long commission) {
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

    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setEmail(String email) { this.email = email; }
    public void setZone(String zone) { this.zone = zone; }
    public void setInternalCode(String internalCode) { this.internalCode = internalCode; }
    public void setCommission(Long commission) { this.commission = commission; }
}
