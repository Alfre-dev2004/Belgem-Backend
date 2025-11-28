package com.belgem.backend.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * TESTS UNITARIOS DEL DOMINIO CLIENTE
 *
 * Este archivo valida que el modelo de dominio `Cliente`:
 *   - Se crea correctamente con datos válidos
 *   - Lanza excepciones cuando las reglas de negocio se violan
 *
 * IMPORTANTE:
 * Estos tests NO prueban base de datos ni servicios.
 * Solo prueban la lógica contenida dentro del constructor
 * del modelo de dominio.
 */
public class ClienteTest {

    /**
     * TEST 1 — Crear cliente válido debe funcionar correctamente.
     * Se comprueban todos los getters para asegurar que el objeto
     * se creó con los valores esperados.
     */
    @Test
    void crearClienteValido_debeCrearCorrectamente() {
        Cliente cliente = new Cliente(
                1L,
                "Juan Pérez",
                "12345678A",
                "Calle Falsa 123",
                "Madrid",
                "28001",
                "600123456",
                "juan@example.com",
                "Premium",
                "Centro",
                "Ana Gómez",
                "Sin observaciones"
        );

        // Verificaciones → El cliente debe haber guardado los datos correctamente
        assertEquals(1L, cliente.getId());
        assertEquals("Juan Pérez", cliente.getNombre());
        assertEquals("12345678A", cliente.getNif());
        assertEquals("Madrid", cliente.getCiudad());
        assertEquals("juan@example.com", cliente.getEmail());
    }

    /**
     * TEST 2 — Error si el nombre está vacío.
     * La regla de negocio indica que el nombre NO puede estar vacío.
     */
    @Test
    void crearCliente_conNombreVacioDebeLanzarError() {
        Exception ex = assertThrows(IllegalArgumentException.class, () ->
                new Cliente(
                        1L,
                        "   ",     // nombre vacío → error
                        "12345678A",
                        "Calle Falsa",
                        "Madrid",
                        "28001",
                        "600123456",
                        "test@example.com",
                        "Premium",
                        "Centro",
                        "Ana",
                        "Obs"
                )
        );

        assertEquals("El nombre no puede estar vacío", ex.getMessage());
    }

    /**
     * TEST 3 — Error si el email NO es válido.
     * El email debe contener '@' según la lógica del dominio.
     */
    @Test
    void crearCliente_conEmailInvalidoDebeLanzarError() {
        Exception ex = assertThrows(IllegalArgumentException.class, () ->
                new Cliente(
                        1L,
                        "Juan",
                        "12345678A",
                        "Calle Falsa",
                        "Madrid",
                        "28001",
                        "600123456",
                        "email-invalido",  // sin @
                        "Premium",
                        "Centro",
                        "Ana",
                        "Obs"
                )
        );

        assertEquals("Email inválido", ex.getMessage());
    }

    /**
     * TEST 4 — Getters deben devolver la información correctamente.
     * Esto valida que la clase es realmente inmutable y consistente.
     */
    @Test
    void getters_debenDevolverValoresCorrectos() {
        Cliente cliente = new Cliente(
                99L,
                "Nombre Test",
                "11111111B",
                "Dir",
                "Ciudad",
                "00000",
                "600000000",
                "correo@test.com",
                "Premium",
                "Zona 1",
                "Pepito Pérez",
                "ninguna"
        );

        assertAll(
                () -> assertEquals(99L, cliente.getId()),
                () -> assertEquals("Nombre Test", cliente.getNombre()),
                () -> assertEquals("11111111B", cliente.getNif()),
                () -> assertEquals("Dir", cliente.getDireccion()),
                () -> assertEquals("Ciudad", cliente.getCiudad()),
                () -> assertEquals("correo@test.com", cliente.getEmail())
        );
    }
}