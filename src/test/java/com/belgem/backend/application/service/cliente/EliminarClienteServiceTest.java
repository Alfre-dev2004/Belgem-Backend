package com.belgem.backend.application.service.cliente;

import com.belgem.backend.domain.port.output.ClienteRepositoryPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * TESTS UNITARIOS del servicio EliminarClienteService.
 *
 * Se usa Mockito para simular el repositorio.
 */
class EliminarClienteServiceTest {

    private ClienteRepositoryPort repo;   // Mock del repositorio
    private EliminarClienteService service;  // Clase a testear

    /**
     * Configuración previa a cada test:
     * - Crear mock del repositorio
     * - Instanciar el servicio con ese mock
     */
    @BeforeEach
    void setup() {
        repo = mock(ClienteRepositoryPort.class);
        service = new EliminarClienteService(repo);
    }

    /**
     * Test 1:
     * Debe eliminar correctamente si el cliente SÍ existe.
     */
    @Test
    void eliminarCliente_debeEliminarSiExiste() {

        // Arrange → repo confirma existencia
        when(repo.existsById(1L)).thenReturn(true);

        // Act
        service.eliminarCliente(1L);

        // Assert → se llamó a existsById y deleteById una sola vez
        verify(repo, times(1)).existsById(1L);
        verify(repo, times(1)).deleteById(1L);
    }

    /**
     * Test 2:
     * Debe lanzar excepción si el cliente NO existe.
     */
    @Test
    void eliminarCliente_debeLanzarErrorSiNoExiste() {

        // Arrange → repo dice que NO existe
        when(repo.existsById(99L)).thenReturn(false);

        // Act + Assert
        RuntimeException error =
                assertThrows(RuntimeException.class, () -> service.eliminarCliente(99L));

        assertEquals("Cliente con id 99 no encontrado.", error.getMessage());

        verify(repo, times(1)).existsById(99L);
        verify(repo, never()).deleteById(anyLong()); // NO debe intentar borrar nada
    }
}

