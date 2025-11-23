package com.belgem.backend.application.service.divisa;

import com.belgem.backend.domain.model.Divisa;
import com.belgem.backend.domain.port.output.DivisaRepositoryPort;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Tests del caso de uso "Listar Divisas".
 * Aquí solo comprobamos que el service delega correctamente en el repositorio
 * y devuelve lo que éste le da.
 */
public class ListarDivisasServiceTest {

    @Test
    void debeDevolverListaVaciaCuandoNoHayDivisas() {
        // Mock del repositorio
        DivisaRepositoryPort repo = mock(DivisaRepositoryPort.class);

        //Service real
        ListarDivisasService service = new ListarDivisasService(repo);


        //El repo devuelve lista vacía
        when(repo.findAll()).thenReturn(List.of());

        // Ejecución del caso de uso
        List<Divisa> resultado = service.listar();

        // Verificación
        assertNotNull(resultado);
        assertTrue(resultado.isEmpty());

        verify(repo, times(1)).findAll();
    }

    @Test
    void debeDevolverTodasLasDivisasCuandoExisten(){
        // Mock del repositorio
        DivisaRepositoryPort repo = mock(DivisaRepositoryPort.class);

        //Service real
        ListarDivisasService service = new ListarDivisasService(repo);

        // Datos de prueba
        Divisa eur = new Divisa(1L, "EUR", "Euro");
        Divisa usd = new Divisa(2L, "USD", "Dólar USA");

        //El repo devuelve una lista con dos divisas
        when(repo.findAll()).thenReturn(List.of(eur, usd));

        // Ejecución del caso de uso
        List<Divisa> resultado = service.listar();

        // Verificación
        assertEquals(2, resultado.size());

        //el test funciona independientemente del orden de los elementos en la lista
        assertTrue(resultado.stream().anyMatch(d -> d.getCode().equals("EUR")));
        assertTrue(resultado.stream().anyMatch(d -> d.getCode().equals("USD")));


        verify(repo, times(1)).findAll();
    }
}
