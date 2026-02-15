package com.belgem.backend.application.service.articulo;

import com.belgem.backend.domain.model.Articulo;
import com.belgem.backend.domain.port.output.ArticuloRepositoryPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ObtenerArticuloPorNombreServiceTest {

    @Mock
    private ArticuloRepositoryPort repo;

    @InjectMocks
    private ObtenerArticuloPorNombreService service;

    @Test
    void debeDevolverArticulosCuandoExisten() {
        // ARRANGE
        Articulo a1 = new Articulo(
                1L,
                "Teclado",
                "ACTIVO",
                25.0,
                1.2,
                5.0,
                30.0,
                10.0,
                true
        );

        Articulo a2 = new Articulo(
                2L,
                "Teclado",
                "ACTIVO",
                30.0,
                1.5,
                6.0,
                35.0,
                12.0,
                true
        );

        when(repo.findByNombre("Teclado")).thenReturn(List.of(a1, a2));

        // ACT
        List<Articulo> resultado = service.buscarPorNombre("Teclado");

        // ASSERT
        assertEquals(2, resultado.size());
        assertEquals("Teclado", resultado.get(0).getNombre());
        assertEquals(25.0, resultado.get(0).getPvpMinimo());

        verify(repo, times(1)).findByNombre("Teclado");
    }

    @Test
    void debeDevolverListaVaciaSiNoExiste() {
        // ARRANGE
        when(repo.findByNombre("Inexistente")).thenReturn(List.of());

        // ACT
        List<Articulo> resultado = service.buscarPorNombre("Inexistente");

        // ASSERT
        assertTrue(resultado.isEmpty());

        verify(repo, times(1)).findByNombre("Inexistente");
    }
}