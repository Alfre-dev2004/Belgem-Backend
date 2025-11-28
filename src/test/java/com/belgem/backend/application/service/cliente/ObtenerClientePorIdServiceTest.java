package com.belgem.backend.application.service.cliente;

import com.belgem.backend.domain.model.Cliente;
import com.belgem.backend.domain.port.output.ClienteRepositoryPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * TESTS UNITARIOS del servicio ObtenerClientePorIdService.
 *
 * Se usa Mockito para simular el comportamiento del repositorio
 * sin conectarse a ninguna base de datos real.
 */
public class ObtenerClientePorIdServiceTest {

    private ClienteRepositoryPort repo;  // Mock del repositorio
    private ObtenerClientePorIdService service; // Clase que vamos a testear

    /**
     * Se ejecuta antes de cada test.
     * - Crea el mock del repo.
     * - Instancia el service con dicho mock.
     */
    @BeforeEach
    void setup() {
        repo = mock(ClienteRepositoryPort.class);
        service = new ObtenerClientePorIdService(repo);
    }

    /**
     * Test 1:
     * Debe retornar correctamente un cliente existente.
     */
    @Test
    void obtenerClientePorId_debeRetornarClienteSiExiste() {

        // Arrange → Simulamos un cliente en el repositorio
        Cliente cliente = new Cliente(
                1L, "Juan", "123A", "Calle Falsa", "Madrid", "28001",
                "600123456", "juan@example.com", "Premium", "Centro", "Ana", ""
        );

        when(repo.findById(1L)).thenReturn(Optional.of(cliente));

        // Act
        Cliente resultado = service.obtenerPorId(1L);

        // Assert
        assertNotNull(resultado);
        assertEquals("Juan", resultado.getNombre());
        verify(repo, times(1)).findById(1L);
    }

    /**
     * Test 2:
     * Debe lanzar excepción si el cliente NO existe en el repositorio.
     */
    @Test
    void obtenerClientePorId_debeLanzarErrorSiNoExiste() {

        // Arrange → Repositorio devuelve vacío
        when(repo.findById(99L)).thenReturn(Optional.empty());

        // Act + Assert
        IllegalArgumentException error =
                assertThrows(IllegalArgumentException.class, () -> service.obtenerPorId(99L));

        assertEquals("Client with id 99 not found.", error.getMessage());

        verify(repo, times(1)).findById(99L);
    }
}

