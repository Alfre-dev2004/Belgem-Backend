package com.belgem.backend.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests de unidad para la clase de dominio Representante.
 * Valida creación correcta y reglas del dominio:
 *  - nombre obligatorio
 *  - email válido
 *  - código interno obligatorio
 * No depende de Spring ni BD
 */
public class RepresentanteTest {

    @Test
    void debeCrearRepresentanteValido() {
        Long id = 1L;
        String name = "Juan Pérez";
        String phone = "670123456";
        String email = "juan67@gmail.com";
        String zone = "Norte";
        String internalCode = "REP-001";
        Long commission = 10L;

        Representante r = new Representante(id, name, phone, email, zone, internalCode, commission);

        // Validamos todos los campos
        assertEquals(id, r.getId());
        assertEquals(name, r.getName());
        assertEquals(phone, r.getPhone());
        assertEquals(email, r.getEmail());
        assertEquals(zone, r.getZone());
        assertEquals(internalCode, r.getInternalCode());
        assertEquals(commission, r.getCommission());
    }

    @Test
    void errorSiNombreVacio() {
        // Validamos que se lanza excepción si nombre vacío
        assertThrows(IllegalArgumentException.class, () ->
                new Representante(1L, "", "600123456", "juan@example.com", "Norte", "REP-001", 10L)
        );
    }

    @Test
    void errorSiCodigoInternoVacio() {
        // Validamos que se lanza excepción si código interno vacío
        assertThrows(IllegalArgumentException.class, () ->
                new Representante(1L, "Juan", "600123456", "juan@example.com", "Norte", "", 10L)
        );
    }

    @Test
    void errorSiEmailInvalido() {
        // Validamos que se lanza excepción si email inválido
        assertThrows(IllegalArgumentException.class, () ->
                new Representante(1L, "Juan", "600123456", "email_malo", "Norte", "REP-001", 10L)
        );
    }
}
