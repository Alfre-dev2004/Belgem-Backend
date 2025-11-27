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
class EliminarRepresentanteServiceTest {

    @Mock
    private RepresentanteRepositoryPort repo; // Mock repositorio

    @InjectMocks
    private EliminarRepresentanteService service; // Servicio real

    @Test
    void debeEliminarRepresentanteCorrectamente() {
        Long id = 1L;

        // Representante existente
        Representante rep = new Representante(id, "Juan", "600", "j@mail.com", "N", "C1", 5L);

        // Configuramos mocks
        when(repo.findById(id)).thenReturn(Optional.of(rep)); // Encuentra
        doNothing().when(repo).deleteById(id); // Simula delete

        // Ejecutamos servicio
        service.eliminar(id);

        // Verificamos que se llamó a deleteById
        verify(repo).deleteById(id);
    }

    @Test
    void debeLanzarErrorSiNoExiste() {
        Long id = 99L;

        // No existe el representante
        when(repo.findById(id)).thenReturn(Optional.empty());

        // Ejecutamos y verificamos excepción
        RuntimeException ex = assertThrows(RuntimeException.class, () -> service.eliminar(id));

        assertEquals("El representante con ID 99 no existe", ex.getMessage());
    }
}
