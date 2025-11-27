package com.belgem.backend.application.service.divisa;

import com.belgem.backend.domain.model.Divisa;
import com.belgem.backend.domain.port.output.DivisaRepositoryPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ActualizarDivisaServiceTest {

    @Mock
    private DivisaRepositoryPort repo;

    @InjectMocks
    private ActualizarDivisaService service;

    @Test
    void debeActualizarDivisaCorrectamente() {
        Long id = 1L;

        Divisa existente = new Divisa(id, "USD", "Dólar");
        Divisa nuevosDatos = new Divisa(null, "USX", "Dólar Belgem +10%");
        Divisa actualizado = new Divisa(id, "USX", "Dólar Belgem +10%");

        when(repo.findById(id)).thenReturn(Optional.of(existente));
        when(repo.save(any(Divisa.class))).thenReturn(actualizado);

        Divisa resultado = service.actualizar(id, nuevosDatos);

        assertNotNull(resultado);
        assertEquals("USX", resultado.getCode());
        assertEquals("Dólar Belgem +10%", resultado.getName());

        verify(repo, times(1)).findById(id);
        verify(repo, times(1)).save(any(Divisa.class));
    }

    @Test
    void debeLanzarErrorSiNoExisteLaDivisa() {
        Long id = 99L;

        when(repo.findById(id)).thenReturn(Optional.empty());

        RuntimeException ex = assertThrows(RuntimeException.class,
                () -> service.actualizar(id, new Divisa(null, "USX", "Algo")));

        assertEquals("Divisa with id 99 not found.", ex.getMessage());
    }
}
