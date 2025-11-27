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
class ActualizarRepresentanteServiceTest {

    @Mock
    private RepresentanteRepositoryPort repo; // Mock del repositorio, no toca BD real

    @InjectMocks
    private ActualizarRepresentanteService service; // Servicio real a testear

    @Test
    void debeActualizarRepresentanteCorrectamente() {
        Long id = 1L;

        // Representante existente antes de actualizar
        Representante existente = new Representante(
                id, "Juan", "600111222", "juan@mail.com", "Norte", "INT001", 10L
        );

        // Nuevos datos para actualizar
        Representante nuevosDatos = new Representante(
                null, "Juan Nuevo", "600222333", "nuevo@mail.com", "Sur", "INT002", 20L
        );

        // Resultado esperado después de actualizar
        Representante actualizado = new Representante(
                id, "Juan Nuevo", "600222333", "nuevo@mail.com", "Sur", "INT002", 20L
        );

        // Configuramos mocks
        when(repo.findById(id)).thenReturn(Optional.of(existente)); // Encuentra al representante
        when(repo.save(any())).thenReturn(actualizado); // Guardado simulado

        // Ejecutamos el servicio
        Representante resultado = service.actualizar(id, nuevosDatos);

        // Validamos que se actualizó correctamente
        assertEquals("Juan Nuevo", resultado.getName());
        verify(repo).save(any()); // Verifica que se llamó a save
    }

    @Test
    void debeLanzarErrorSiNoExisteElRepresentante() {
        Long id = 99L;

        // Configuramos mock: no encuentra al representante
        when(repo.findById(id)).thenReturn(Optional.empty());

        // Ejecutamos y verificamos que lanza excepción
        RuntimeException ex = assertThrows(RuntimeException.class,
                () -> service.actualizar(id, new Representante(null, "X", "X", "X", "X", "X", 1L)));

        assertEquals("El representante con ID 99 no existe", ex.getMessage());
    }
}
