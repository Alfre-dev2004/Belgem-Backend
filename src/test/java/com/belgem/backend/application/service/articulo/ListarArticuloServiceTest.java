package com.belgem.backend.application.service.articulo;

import com.belgem.backend.domain.model.Articulo;
import com.belgem.backend.domain.port.output.ArticuloRepositoryPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ListarArticuloServiceTest {

    @Mock
    private ArticuloRepositoryPort repo;

    @InjectMocks
    private ListarArticuloService service;

    @Test
    void debeDevolverListaConArticulos() {
        // ARRANGE
        Articulo a1 = new Articulo(
                1L,
                "Teclado",
                "ACTIVO",
                20.0,
                1.2,
                5.0,
                30.0,
                10.0,
                true
        );

        Articulo a2 = new Articulo(
                2L,
                "Mouse",
                "ACTIVO",
                10.0,
                0.3,
                3.0,
                6.0,
                4.0,
                true
        );

        List<Articulo> listaMock = List.of(a1, a2);

        when(repo.findAll()).thenReturn(listaMock);

        // ACT
        List<Articulo> resultado = service.listar();

        // ASSERT
        assertEquals(2, resultado.size());
        assertEquals("Teclado", resultado.get(0).getNombre());
        assertEquals("Mouse", resultado.get(1).getNombre());

        verify(repo, times(1)).findAll();
    }

    @Test
    void debeDevolverListaVacia() {
        // ARRANGE
        when(repo.findAll()).thenReturn(List.of());

        // ACT
        List<Articulo> resultado = service.listar();

        // ASSERT
        assertTrue(resultado.isEmpty());
        verify(repo, times(1)).findAll();
    }
}
