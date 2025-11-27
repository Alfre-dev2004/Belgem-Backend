package com.belgem.backend.application.service.representante;

import com.belgem.backend.domain.model.Representante;
import com.belgem.backend.domain.port.output.RepresentanteRepositoryPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ListarRepresentantesServiceTest {

    @Mock
    private RepresentanteRepositoryPort repo; // Mock repositorio

    @InjectMocks
    private ListarRepresentantesService service; // Servicio real

    @Test
    void debeListarRepresentantesCorrectamente() {
        Representante r1 = new Representante(1L, "A", "1", "a@mail.com", "N", "C1", 5L);
        Representante r2 = new Representante(2L, "B", "2", "b@mail.com", "S", "C2", 6L);

        // Configuramos mock
        when(repo.findAll()).thenReturn(List.of(r1, r2));

        // Ejecutamos servicio
        List<Representante> resultado = service.listar();

        // Validamos resultados
        assertEquals(2, resultado.size());
        verify(repo).findAll(); // Verifica llamada
    }

    @Test
    void debeDevolverListaVaciaSiNoHayRepresentantes() {
        when(repo.findAll()).thenReturn(List.of()); // Lista vacía

        List<Representante> resultado = service.listar();

        assertTrue(resultado.isEmpty());
        verify(repo).findAll();
    }
}
