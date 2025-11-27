package com.belgem.backend.application.service.articulo;

import com.belgem.backend.domain.model.Articulo;
import com.belgem.backend.domain.port.output.ArticuloRepositoryPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CrearArticuloServiceTest {

    @Mock
    private ArticuloRepositoryPort repo;

    @InjectMocks
    private CrearArticuloService service;

    private Articulo articulo;

    @BeforeEach
    void setUp() {
        articulo = new Articulo(
                1L,
                10,
                10.0,
                "Teclado",
                20.0
        );
    }

    @Test
    void debeCrearArticuloCorrectamente() {
        // ARRANGE
        when(repo.existsByNombre("Teclado")).thenReturn(false);
        when(repo.save(any())).thenReturn(articulo);

        // ACT
        Articulo resultado = service.crear(articulo);

        // ASSERT
        assertNotNull(resultado);
        assertEquals("Teclado", resultado.getNombre());
        assertEquals(20.0, resultado.getPrecio());

        verify(repo).existsByNombre("Teclado");
        verify(repo).save(articulo);
    }

    @Test
    void debeLanzarErrorSiArticuloYaExiste() {
        // ARRANGE
        when(repo.existsByNombre("Teclado")).thenReturn(true);

        // ACT + ASSERT
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> service.crear(articulo)
        );

        assertEquals("Ya existe un artículo con ese nombre", ex.getMessage());

        verify(repo).existsByNombre("Teclado");
        verify(repo, never()).save(any());
    }

}