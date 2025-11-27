package com.belgem.backend.application.service.representante;

import com.belgem.backend.domain.model.Representante;
import com.belgem.backend.domain.port.output.RepresentanteRepositoryPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ObtenerRepresentantePorIdServiceTest {

    @Mock
    private RepresentanteRepositoryPort repo; // Mock repositorio

    @InjectMocks
    private ObtenerRepresentantePorIdService service; // Servicio real

    @Test
    void debeDevolverRepresentanteSiExiste() {
        Long id = 1L;

        Representante rep = new Representante(id, "Juan", "600", "j@mail.com", "N", "C1", 5L);

        when(repo.findById(id)).thenReturn(Optional.of(rep)); // Encuentra representante

        Representante resultado = service.obtener(id);

        assertEquals(id, resultado.getId());
        verify(repo).findById(id); // Verifica llamada
    }

    @Test
    void debeLanzarErrorSiNoExiste() {
        Long id = 99L;

        when(repo.findById(id)).thenReturn(Optional.empty()); // No existe

        RuntimeException ex = assertThrows(RuntimeException.class, () -> service.obtener(id));

        assertEquals("El representante con ID 99 no existe.", ex.getMessage());
    }
}
