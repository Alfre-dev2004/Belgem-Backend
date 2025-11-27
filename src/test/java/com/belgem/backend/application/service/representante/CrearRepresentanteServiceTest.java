package com.belgem.backend.application.service.representante;

import com.belgem.backend.domain.model.Representante;
import com.belgem.backend.domain.port.output.RepresentanteRepositoryPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CrearRepresentanteServiceTest {

    @Mock
    private RepresentanteRepositoryPort repo; // Mock del repositorio

    @InjectMocks
    private CrearRepresentanteService service; // Servicio real

    @Test
    void debeCrearRepresentanteCorrectamente() {
        // Representante de ejemplo
        Representante rep = new Representante(
                1L, "Juan", "600111222", "juan@mail.com", "Norte", "INT001", 10L
        );

        // Configuramos mocks
        when(repo.existsByInternalCode("INT001")).thenReturn(false); // Código no duplicado
        when(repo.save(any())).thenReturn(rep); // Guardado simulado

        // Ejecutamos el servicio
        Representante resultado = service.crear(rep);

        // Validamos resultado
        assertEquals(rep.getEmail(), resultado.getEmail());
        verify(repo).save(rep); // Verifica que se llamó save
    }

    @Test
    void debeLanzarErrorSiEmailOCodigoYaExiste() {
        // Representante duplicado
        Representante rep = new Representante(
                null, "Juan", "600111222", "juan@mail.com", "Norte", "INT001", 10L
        );

        // Ejecutamos y verificamos excepción
        RuntimeException ex = assertThrows(RuntimeException.class, () -> service.crear(rep));

        assertEquals("Email o código duplicado", ex.getMessage());
    }
}
