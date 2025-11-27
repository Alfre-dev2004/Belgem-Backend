package com.belgem.backend.application.service.divisa;

import com.belgem.backend.domain.model.Divisa;
import com.belgem.backend.domain.port.output.DivisaRepositoryPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ListarDivisasServiceTest {

    @Mock
    private DivisaRepositoryPort repo;

    @InjectMocks
    private ListarDivisasService service;

    @Test
    void debeDevolverTodasLasDivisasCuandoExisten() {
        Divisa d1 = new Divisa(1L, "EUR", "Euro");
        Divisa d2 = new Divisa(2L, "USD", "Dólar USA");

        when(repo.findAll()).thenReturn(List.of(d1, d2));

        List<Divisa> resultado = service.listar();

        assertEquals(2, resultado.size());
        assertEquals("EUR", resultado.get(0).getCode());
        assertEquals("USD", resultado.get(1).getCode());

        verify(repo, times(1)).findAll();
    }

    @Test
    void debeDevolverListaVaciaSiNoHayDivisas() {
        when(repo.findAll()).thenReturn(List.of());

        List<Divisa> resultado = service.listar();

        assertTrue(resultado.isEmpty());

        verify(repo, times(1)).findAll();
    }
}
