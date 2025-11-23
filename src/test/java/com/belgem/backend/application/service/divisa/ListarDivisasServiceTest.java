package com.belgem.backend.application.service.divisa;

import com.belgem.backend.domain.model.Divisa;
import com.belgem.backend.domain.port.output.DivisaRepositoryPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Tests unitarios para ListarDivisasService.
 * Verifican que el servicio:
 *  - Devuelve lista vacía cuando no hay divisas.
 *  - Devuelve todas las divisas cuando el repositorio tiene datos.
 */
@ExtendWith(MockitoExtension.class)
class ListarDivisasServiceTest {

    @Mock
    private DivisaRepositoryPort repository;

    @InjectMocks
    private ListarDivisasService service;

    @Test
    void debeDevolverListaVaciaCuandoNoHayDivisas() {
        // Given
        when(repository.findAll()).thenReturn(Collections.emptyList());

        // When
        List<Divisa> resultado = service.listar();

        // Then
        assertNotNull(resultado);
        assertTrue(resultado.isEmpty());
        verify(repository, times(1)).findAll();
    }

    @Test
    void debeDevolverTodasLasDivisasCuandoExisten() {
        // Given
        Divisa eur = new Divisa(1L, "EUR", "Euro");
        Divisa usd = new Divisa(2L, "USD", "Dólar USA");

        List<Divisa> divisas = List.of(eur, usd);
        when(repository.findAll()).thenReturn(divisas);

        // When
        List<Divisa> resultado = service.listar();

        // Then
        assertNotNull(resultado);
        assertEquals(2, resultado.size());
        assertEquals("EUR", resultado.get(0).getCode());
        assertEquals("USD", resultado.get(1).getCode());
        verify(repository, times(1)).findAll();
    }
}
