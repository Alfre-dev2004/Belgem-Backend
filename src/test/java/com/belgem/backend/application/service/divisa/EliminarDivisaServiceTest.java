package com.belgem.backend.application.service.divisa;

import com.belgem.backend.domain.port.output.DivisaRepositoryPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EliminarDivisaServiceTest {

    @Mock
    private DivisaRepositoryPort repository;

    @InjectMocks
    private EliminarDivisaService service;

    @Test
    void debeLanzarErrorSiDivisaNoExiste() {
        // Given
        Long id = 99L;
        when(repository.findById(id)).thenReturn(java.util.Optional.empty());

        // When + Then
        assertThrows(RuntimeException.class, () -> service.eliminarDivisa(id));
        verify(repository, never()).deleteById(anyLong());
    }

    @Test
    void debeEliminarDivisaCuandoExiste() {
        // Given
        Long id = 1L;
        when(repository.findById(id)).thenReturn(java.util.Optional.of(
                new com.belgem.backend.domain.model.Divisa(id, "EUR", "Euro")
        ));

        // When
        service.eliminarDivisa(id);

        // Then
        verify(repository, times(1)).deleteById(id);
    }
}

