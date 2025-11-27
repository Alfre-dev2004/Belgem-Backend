package com.belgem.backend.application.service.representante;

import com.belgem.backend.domain.port.output.RepresentanteRepositoryPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EliminarRepresentanteServiceTest {

    private RepresentanteRepositoryPort repository;
    private EliminarRepresentanteService service;

    @BeforeEach
    void setUp() {
        repository = mock(RepresentanteRepositoryPort.class);
        service = new EliminarRepresentanteService(repository);
    }

    @Test
    void debeEliminarRepresentanteCorrectamente() {
        Long id = 1L;

        // Configuramos el mock para que exista el ID
        when(repository.existsById(id)).thenReturn(true);

        // Ejecutamos el método
        assertDoesNotThrow(() -> service.eliminar(id));

        // Verificamos que se llame al delete
        verify(repository, times(1)).deleteById(id);
    }

    @Test
    void debeLanzarErrorSiNoExiste() {
        Long id = 2L;

        // Configuramos el mock para que NO exista el ID
        when(repository.existsById(id)).thenReturn(false);

        // Verificamos que lance la excepción
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> service.eliminar(id));
        assertEquals("El representante con ID " + id + " no existe.", exception.getMessage());

        // Verificamos que delete nunca se haya llamado
        verify(repository, never()).deleteById(anyLong());
    }
}
