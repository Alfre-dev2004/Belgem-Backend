package com.belgem.backend.application.service.articulo;

import com.belgem.backend.domain.exception.ArticuloNoEncontradoException;
import com.belgem.backend.domain.port.output.ArticuloRepositoryPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EliminarArticuloServiceTest {

    @Mock
    private ArticuloRepositoryPort repo;

    @InjectMocks
    private EliminarArticuloService service;

    @Test
    void debeEliminarCuandoExiste() {
        // ARRANGE
        Long id = 1L;
        when(repo.existsById(id)).thenReturn(true);

        // ACT
        service.eliminar(id);

        // ASSERT
        verify(repo).existsById(id);
        verify(repo).deleteById(id);
    }

    @Test
    void debeLanzarExcepcionCuandoNoExiste() {
        // ARRANGE
        Long id = 50L;
        when(repo.existsById(id)).thenReturn(false);

        // ACT + ASSERT
        assertThrows(ArticuloNoEncontradoException.class,
                () -> service.eliminar(id));

        verify(repo).existsById(id);
        verify(repo, never()).deleteById(any());
    }
}