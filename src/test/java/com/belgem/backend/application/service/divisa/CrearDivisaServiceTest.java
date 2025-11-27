package com.belgem.backend.application.service.divisa;

import com.belgem.backend.domain.model.Divisa;
import com.belgem.backend.domain.port.output.DivisaRepositoryPort;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class CrearDivisaServiceTest {
    @Test
    void debeCrearDivisaCuandoNoExiste() {
        //Mock del repositorio
        DivisaRepositoryPort repo = mock(DivisaRepositoryPort.class);

        //Service real
        CrearDivisaService service = new CrearDivisaService(repo);

        //Divisa de entrada
        Divisa entrada = new Divisa(null, "EUR", "Euro");

        //configuramos mocks
        when(repo.existsByCode("EUR")).thenReturn(false);
        when(repo.save(entrada))
                .thenReturn(new Divisa(1L, "EUR", "Euro"));

        //Ejecutamos el caso de uso
        Divisa resultado = service.crear(entrada);

        //Validamos comportamiento
        assertEquals("EUR", resultado.getCode());
        assertEquals("Euro", resultado.getName());

        //verificamos que se llamó a save
        verify(repo).save(entrada);
    }

    @Test
    void debeLanzarErrorSiExisteLaDivisa() {
        //Mock del repositorio
        DivisaRepositoryPort repo = mock(DivisaRepositoryPort.class);

        //Service real
        CrearDivisaService service = new CrearDivisaService(repo);

        //Divisa de entrada
        Divisa entrada = new Divisa(null, "EUR", "Euro");

        //configuramos mocks
        when(repo.existsByCode("EUR")).thenReturn(true);

        RuntimeException ex = assertThrows(
                RuntimeException.class,
                () -> service.crear(entrada)
        );
        assertTrue(ex.getMessage().contains("Divisa with code EUR already exists"));
        verify(repo, never()).save(any());
    }

    @Test
    void debeCrearDivisaValida(){
        //Mock del repositorio
        DivisaRepositoryPort repo = mock(DivisaRepositoryPort.class);

        //Service real
        CrearDivisaService service = new CrearDivisaService(repo);

        //Divisa de entrada
        Divisa entrada = new Divisa(null, "USD", "Dólar USA");

        //configuramos mocks
        when(repo.existsByCode("USD")).thenReturn(false);
        when(repo.save(entrada))
                .thenReturn(new Divisa(5L, "USD", "Dólar USA"));

        //Ejecutamos el caso de uso
        Divisa resultado = service.crear(entrada);

        //Validamos comportamiento
        assertNotNull(resultado);
        assertEquals("USD", resultado.getCode());
        assertEquals("Dólar USA", resultado.getName());

        //verificamos que se llamó a save
        verify(repo).save(entrada);
    }
}