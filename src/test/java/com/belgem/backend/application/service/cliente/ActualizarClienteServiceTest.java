package com.belgem.backend.application.service.cliente;

import com.belgem.backend.domain.model.Cliente;
import com.belgem.backend.domain.port.output.ClienteRepositoryPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * TESTS UNITARIOS del servicio ActualizarClienteService.
 *
 * Se usa Mockito para simular el repositorio sin BD real.
 */
public class ActualizarClienteServiceTest {

    private ClienteRepositoryPort repo;   // Mock del repositorio
    private ActualizarClienteService service; // Clase a testear

    /**
     * Configuración previa a cada test:
     * - Crear mock del repositorio
     * - Instanciar el service usando ese mock
     */
    @BeforeEach
    void setup() {
        repo = mock(ClienteRepositoryPort.class);
        service = new ActualizarClienteService(repo);
    }

    /**
     * Test 1:
     * Debe actualizar correctamente si el cliente existe.
     */
    @Test
    void actualizarCliente_debeActualizarSiExiste() {

        // Arrange → Cliente original existente
        Cliente existente = new Cliente(
                1L, "Juan", "123A", "Calle Falsa", "Madrid", "28001",
                "600123456", "juan@example.com", "Premium", "Centro", "Ana", ""
        );

        // Datos nuevos (simulan venir del frontend)
        Cliente nuevosDatos = new Cliente(
                null, "Juan Actualizado", null, "Nueva Calle", "Barcelona",
                "08001", "622000111", "nuevo@example.com",
                "VIP", "Norte", "Luis", "Actualizado"
        );

        // El repo devuelve el existente cuando se busca por ID
        when(repo.findById(1L)).thenReturn(Optional.of(existente));

        // El repo debe guardar y devolver el cliente actualizado
        when(repo.save(any(Cliente.class))).thenAnswer(invocation -> invocation.getArgument(0));

        // Act
        Cliente actualizado = service.actualizarCliente(1L, nuevosDatos);

        // Assert
        assertNotNull(actualizado);
        assertEquals(1L, actualizado.getId());             // ID se conserva
        assertEquals("123A", actualizado.getNif());        // NIF se conserva
        assertEquals("Juan Actualizado", actualizado.getNombre());
        assertEquals("nuevo@example.com", actualizado.getEmail());

        // Verificamos llamadas al repositorio
        verify(repo, times(1)).findById(1L);
        verify(repo, times(1)).save(any(Cliente.class));
    }

    /**
     * Test 2:
     * Debe lanzar excepción si el cliente NO existe.
     */
    @Test
    void actualizarCliente_debeLanzarErrorSiNoExiste() {

        // Arrange → El repo devuelve vacío (no existe)
        when(repo.findById(99L)).thenReturn(Optional.empty());

        // Nuevos datos (no importa su contenido porque nunca se llegará a usar)
        Cliente datos = new Cliente(
                null, "Pedro", null, null, null, null, null,
                "pedro@example.com", null, null, null, ""
        );

        // Act + Assert
        IllegalArgumentException error =
                assertThrows(IllegalArgumentException.class,
                        () -> service.actualizarCliente(99L, datos));

        assertEquals("Cliente with id 99 not found.", error.getMessage());

        verify(repo, times(1)).findById(99L);
        verify(repo, never()).save(any()); // IMPORTANTÍSIMO
    }
}

