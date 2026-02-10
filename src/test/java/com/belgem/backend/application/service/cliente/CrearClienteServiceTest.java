package com.belgem.backend.application.service.cliente;


import com.belgem.backend.domain.model.Cliente;
import com.belgem.backend.domain.port.output.ClienteRepositoryPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
/**
 * TESTS UNITARIOS DE CrearClienteService
 * Importante:
 *   - No usa base de datos real
 *   - Utiliza Mockito para simular el repositorio
 *   - Testea únicamente la lógica del service
 */
public class CrearClienteServiceTest {
    private ClienteRepositoryPort repo;  // Mock del repositorio
    private CrearClienteService service; // Clase a testear

    /**
     * Se ejecuta antes de cada test.
     * Prepara los mocks usando Mockito.
     */
    @BeforeEach
    void setup() {
        repo = Mockito.mock(ClienteRepositoryPort.class);
        service = new CrearClienteService(repo);
    }

    /**
     * TEST 1 — Crear cliente correctamente
     *
     * Verifica que:
     *   - El repositorio confirme que NO existe el NIF
     *   - El service llame a save()
     *   - El cliente resultante sea el esperado
     */
    @Test
    void crearCliente_correcto_debeGuardarCliente() {

        Cliente cliente = new Cliente(
                null,
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
                "Obs"
        );

        // Simulamos que el NIF NO existe
        when(repo.existsByNif("12345678A")).thenReturn(false);

        // Simulamos que save devuelve el cliente guardado
        when(repo.save(cliente)).thenReturn(
                new Cliente(
                        1L,
                        cliente.getNombre(),
                        cliente.getNif(),
                        cliente.getDireccion(),
                        cliente.getCiudad(),
                        cliente.getCodigoPostal(),
                        cliente.getTelefono(),
                        cliente.getEmail(),
                        cliente.getTipoCliente(),
                        cliente.getZona(),
                        cliente.getRepresentante(),
                        cliente.getObservaciones()
                )
        );

        Cliente result = service.crearCliente(cliente);

        assertNotNull(result.getId()); // Debe devolver ID asignado
        assertEquals("Juan Pérez", result.getNombre());

        // Verificamos que el repositorio fue llamado correctamente
        verify(repo, times(1)).existsByNif("12345678A");
        verify(repo, times(1)).save(cliente);
    }

    /**
     * TEST 2 — Error si el NIF ya existe
     *
     * El service debe lanzar excepción si se intenta registrar
     * un cliente con un NIF que ya está registrado.
     */
    @Test
    void crearCliente_conNifExistente_debeLanzarExcepcion() {

        Cliente cliente = new Cliente(
                null,
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
                "Obs"
        );

        // Indicamos que el NIF YA existe en BD
        when(repo.existsByNif("12345678A")).thenReturn(true);

        IllegalArgumentException e = assertThrows(
                IllegalArgumentException.class,
                () -> service.crearCliente(cliente)
        );

        assertEquals("Client with NIF 12345678A already exists.", e.getMessage());

        // save() JAMÁS debería ser llamado si el NIF existe
        verify(repo, never()).save(any());
    }
}
