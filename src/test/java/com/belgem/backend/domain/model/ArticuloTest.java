package com.belgem.backend.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ArticuloTest {

    @Test
    void debeCrearArticuloValido() {
        // ARRANGE
        Long id = 1L;
        String nombre = "Teclado";
        String situacion = "ACTIVO";
        Double pvpMinimo = 50.0;
        Double pesoKg = 1.2;
        Double altoCm = 5.0;
        Double anchoCm = 40.0;
        Double largoCm = 15.0;
        Boolean vendible = true;

        // ACT
        Articulo articulo = new Articulo(
                id,
                nombre,
                situacion,
                pvpMinimo,
                pesoKg,
                altoCm,
                anchoCm,
                largoCm,
                vendible
        );

        // ASSERT
        assertEquals(id, articulo.getId());
        assertEquals(nombre, articulo.getNombre());
        assertEquals(situacion, articulo.getSituacion());
        assertEquals(pvpMinimo, articulo.getPvpMinimo());
        assertEquals(pesoKg, articulo.getPesoKg());
        assertEquals(altoCm, articulo.getAltoCm());
        assertEquals(anchoCm, articulo.getAnchoCm());
        assertEquals(largoCm, articulo.getLargoCm());
        assertEquals(vendible, articulo.getVendible());
    }

    @Test
    void noDebePermitirNombreVacio() {
        assertThrows(IllegalArgumentException.class, () ->
                new Articulo(
                        1L,
                        "  ",
                        "ACTIVO",
                        50.0,
                        1.0,
                        10.0,
                        10.0,
                        10.0,
                        true
                )
        );
    }

    @Test
    void noDebePermitirPvpMinimoNegativo() {
        assertThrows(IllegalArgumentException.class, () ->
                new Articulo(
                        1L,
                        "Laptop",
                        "ACTIVO",
                        -1.0,
                        1.0,
                        10.0,
                        10.0,
                        10.0,
                        true
                )
        );
    }

    @Test
    void noDebePermitirPesoNegativo() {
        assertThrows(IllegalArgumentException.class, () ->
                new Articulo(
                        1L,
                        "Mouse",
                        "ACTIVO",
                        15.0,
                        -3.0,
                        10.0,
                        10.0,
                        10.0,
                        true
                )
        );
    }

    @Test
    void noDebePermitirDimensionesNegativas() {
        assertThrows(IllegalArgumentException.class, () ->
                new Articulo(
                        1L,
                        "Pantalla",
                        "ACTIVO",
                        120.0,
                        5.0,
                        -1.0,
                        50.0,
                        20.0,
                        true
                )
        );
    }

    @Test
    void noDebePermitirSituacionInvalida() {
        assertThrows(IllegalArgumentException.class, () ->
                new Articulo(
                        1L,
                        "Cargador",
                        "BORRADO",
                        20.0,
                        0.5,
                        5.0,
                        5.0,
                        5.0,
                        true
                )
        );
    }
}