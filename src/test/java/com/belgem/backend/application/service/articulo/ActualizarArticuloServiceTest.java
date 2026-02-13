package com.belgem.backend.application.service.articulo;

import com.belgem.backend.domain.exception.ArticuloNoEncontradoException;
import com.belgem.backend.domain.model.Articulo;
import com.belgem.backend.domain.port.output.ArticuloRepositoryPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ActualizarArticuloServiceTest {

    @Mock
    private ArticuloRepositoryPort repo;

    @InjectMocks
    private ActualizarArticuloService service;

    @Test
    void debeActualizarArticuloExistente() {
        // ARRANGE
        Long id = 1L;

        Articulo existente = new Articulo(
                id,
                "Teclado",
                "ACTIVO",
                20.0,
                1.0,
                5.0,
                30.0,
                10.0,
                true
        );

        Articulo nuevosDatos = new Articulo(
                id,
                "Pantalla",
                "ACTIVO",
                30.0,
                3.0,
                40.0,
                60.0,
                10.0,
                true
        );

        when(repo.findById(id)).thenReturn(Optional.of(existente));
        when(repo.existsByNombre("Pantalla")).thenReturn(false);
        when(repo.save(any())).thenAnswer(invocation -> invocation.getArgument(0));

        // ACT
        Articulo actualizado = service.actualizar(id, nuevosDatos);

        // ASSERT
        assertNotNull(actualizado);
        assertEquals("Pantalla", actualizado.getNombre());
        assertEquals(30.0, actualizado.getPvpMinimo());
        assertEquals(3.0, actualizado.getPesoKg());
        assertEquals(40.0, actualizado.getAltoCm());
        assertEquals(60.0, actualizado.getAnchoCm());
        assertEquals(10.0, actualizado.getLargoCm());
        assertTrue(actualizado.getVendible());

        verify(repo).findById(id);
        verify(repo).existsByNombre("Pantalla");
        verify(repo).save(any(Articulo.class));
    }

    @Test
    void debeLanzarExcepcionSiIdNoExiste() {
        // ARRANGE
        Long id = 99L;

        Articulo datos = new Articulo(
                id,
                "Nuevo",
                "ACTIVO",
                20.0,
                1.0,
                10.0,
                10.0,
                10.0,
                true
        );

        when(repo.findById(id)).thenReturn(Optional.empty());

        // ACT + ASSERT
        assertThrows(ArticuloNoEncontradoException.class,
                () -> service.actualizar(id, datos));

        verify(repo).findById(id);
        verify(repo, never()).save(any());
    }

    @Test
    void debeLanzarExcepcionSiNombreDuplicado() {
        // ARRANGE
        Long id = 1L;

        Articulo existente = new Articulo(
                id,
                "Mouse",
                "ACTIVO",
                15.0,
                0.5,
                5.0,
                5.0,
                5.0,
                true
        );

        Articulo nuevosDatos = new Articulo(
                id,
                "Teclado",
                "ACTIVO",
                20.0,
                1.0,
                10.0,
                10.0,
                10.0,
                true
        );

        when(repo.findById(id)).thenReturn(Optional.of(existente));
        when(repo.existsByNombre("Teclado")).thenReturn(true);

        // ACT + ASSERT
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> service.actualizar(id, nuevosDatos)
        );

        assertEquals("Ya existe un artículo con ese nombre", ex.getMessage());

        verify(repo).findById(id);
        verify(repo).existsByNombre("Teclado");
        verify(repo, never()).save(any());
    }
}
