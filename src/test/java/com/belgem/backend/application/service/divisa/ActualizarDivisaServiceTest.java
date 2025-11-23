package com.belgem.backend.application.service.divisa;

import com.belgem.backend.domain.model.Divisa;
import com.belgem.backend.domain.port.output.DivisaRepositoryPort;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Tests del caso de uso "Actualizar Divisa".
 * Aquí mockeamos el repositorio y comprobamos:
 *  - Que si la divisa existe, se actualiza correctamente.
 *  - Que si NO existe, lanza una excepción y NO guarda nada.
 */
public class ActualizarDivisaServiceTest {
    @Test
    void debeActualizarDivisaCuandoExiste(){
        //Arrange
        DivisaRepositoryPort repo = mock(DivisaRepositoryPort.class);
        ActualizarDivisaService service = new ActualizarDivisaService(repo);

        Long id = 1L;
        // Divisa que ya existe en BD
        Divisa existente = new Divisa(id, "EUR", "Euro");

        // Nuevos datos que queremos aplicar
        Divisa nuevosDatos = new Divisa(null, "USX", "Dólar Belgem +10%");

        // Lo que devuelve la BD cuando buscamos por id
        when(repo.findById(id)).thenReturn(Optional.of(existente));

        // Lo que devuelve al guardar (ya "actualizada")
        Divisa divisaActualizada = new Divisa(id, "USX", "Dólar Belgem +10%");
        when(repo.save(any(Divisa.class))).thenReturn(divisaActualizada);

        // Act
        Divisa resultado = service.actualizar(id, nuevosDatos); //

        // Assert
        assertNotNull(resultado);
        assertEquals(id, resultado.getId());
        assertEquals("USX", resultado.getCode());
        assertEquals("Dólar Belgem +10%", resultado.getName());

        // Verificamos interacciones
        verify(repo, times(1)).findById(id);
        verify(repo, times(1)).save(any(Divisa.class));
    }

    @Test
    void debeLanzarErrorSiLaDivisaNoExiste() {
        // Arrange
        DivisaRepositoryPort repo = mock(DivisaRepositoryPort.class);
        ActualizarDivisaService service = new ActualizarDivisaService(repo);

        Long id = 99L;
        Divisa nuevosDatos = new Divisa(null, "GBP", "Libra esterlina");

        // Simulamos que NO existe la divisa con ese id
        when(repo.findById(id)).thenReturn(Optional.empty());

        // Act + Assert
        RuntimeException ex = assertThrows(
                RuntimeException.class,
                () -> service.actualizar(id, nuevosDatos) // 👈 igual, cambia el nombre si hace falta
        );

        assertTrue(ex.getMessage().contains("Divisa with id " + id));

        // Aseguramos que NO se llama a save si no existe
        verify(repo, times(1)).findById(id);
        verify(repo, never()).save(any());
    }
}
