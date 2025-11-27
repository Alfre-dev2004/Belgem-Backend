package com.belgem.backend.application.service.divisa;

import com.belgem.backend.domain.model.Divisa;
import com.belgem.backend.domain.port.output.DivisaRepositoryPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ObtenerDivisaPorIdServiceTest {

    @Mock
    private DivisaRepositoryPort repository;

    @InjectMocks
    private ObtenerDivisaPorIdService service;

    @Test
    void debeRetornarDivisaCuandoExiste() {
        // Given
        Long id = 1L;
        Divisa divisa = new Divisa(id, "EUR", "Euro");

        when(repository.findById(id)).thenReturn(Optional.of(divisa));

        // When
        Divisa resultado = service.obtener(id);

        // Then
        assertNotNull(resultado);
        assertEquals(id, resultado.getId());
        assertEquals("EUR", resultado.getCode());
        assertEquals("Euro", resultado.getName());

        verify(repository, times(1)).findById(id);
    }

    @Test
    void debeLanzarErrorCuandoDivisaNoExiste() {
        // Given
        Long id = 999L;
        when(repository.findById(id)).thenReturn(Optional.empty());

        // When + Then
        RuntimeException ex = assertThrows(RuntimeException.class, () -> service.obtener(id));

        assertEquals("Divisa with id " + id + " not found.", ex.getMessage());
        verify(repository, times(1)).findById(id);
    }
}
