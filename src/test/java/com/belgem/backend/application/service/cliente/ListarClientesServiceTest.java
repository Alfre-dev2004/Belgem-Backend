package com.belgem.backend.application.service.cliente;

import com.belgem.backend.domain.model.Cliente;
import com.belgem.backend.domain.port.output.ClienteRepositoryPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * TESTS UNITARIOS DE ListarClientesService
 *
 * Características:
 *   - No usa base de datos real
 *   - Utiliza mocks con Mockito
 *   - Testea únicamente la lógica del caso de uso
 */
public class ListarClientesServiceTest {

    private ClienteRepositoryPort repo;
    private ListarClientesService service;

    @BeforeEach
    void setup() {
        repo = Mockito.mock(ClienteRepositoryPort.class);
        service = new ListarClientesService(repo);
    }

    /**
     * TEST 1 — Lista normal con clientes
     *
     * Simulamos que el repositorio devuelve 2 clientes
     * y comprobamos que el service devuelve exactamente esa misma lista.
     */
    @Test
    void listarClientes_debeDevolverListaCompleta() {

        Cliente c1 = new Cliente(
                1L, "Juan", "123A", "Calle 1", "Madrid", "28001",
                "600111222", "a@a.com", "Premium", "Centro", "Luis", "Obs"
        );

        Cliente c2 = new Cliente(
                2L, "Ana", "456B", "Calle 2", "Madrid", "28002",
                "600222333", "b@b.com", "Basico", "Norte", "Maria", "Nada"
        );

        when(repo.findAll()).thenReturn(List.of(c1, c2));

        List<Cliente> resultado = service.listarClientes();

        assertEquals(2, resultado.size());
        assertEquals("Juan", resultado.get(0).getNombre());
        assertEquals("Ana", resultado.get(1).getNombre());

        verify(repo, times(1)).findAll();
    }

    /**
     * TEST 2 — Lista vacía
     *
     * El repositorio puede devolver una lista vacía, y eso es correcto.
     * El service debe regresar esa lista tal cual.
     */
    @Test
    void listarClientes_listaVacia_debeDevolverListaVacia() {

        when(repo.findAll()).thenReturn(List.of()); // lista vacía

        List<Cliente> resultado = service.listarClientes();

        assertTrue(resultado.isEmpty());
        assertEquals(0, resultado.size());

        verify(repo, times(1)).findAll();
    }
}

