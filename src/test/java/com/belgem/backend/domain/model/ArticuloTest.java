package com.belgem.backend.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ArticuloTest {

    @Test
    void debeCrearArticuloValido() {
        // ARRANGE
        Long id = 1L;
        Integer cantidad = 10;
        Double dto = 15.0;
        String nombre = "Teclado";
        Double precio = 50.0;

        // ACT
        Articulo articulo = new Articulo(id, cantidad, dto, nombre, precio);

        // ASSERT
        assertEquals(id, articulo.getId());
        assertEquals(cantidad, articulo.getCantidad());
        assertEquals(dto, articulo.getDto());
        assertEquals(nombre, articulo.getNombre());
        assertEquals(precio, articulo.getPrecio());
    }

    @Test
    void noDebePermitirNombreVacio() {
        assertThrows(IllegalArgumentException.class, () ->
                new Articulo(1L, 5, 10.0, "  ", 100.0)
        );
    }

    @Test
    void noDebePermitirPrecioNegativo() {
        assertThrows(IllegalArgumentException.class, () ->
                new Articulo(1L, 5, 10.0, "Laptop", -1.0)
        );
    }

    @Test
    void noDebePermitirCantidadNegativa() {
        assertThrows(IllegalArgumentException.class, () ->
                new Articulo(1L, -3, 10.0, "Mouse", 15.0)
        );
    }

    @Test
    void noDebePermitirDtoMenorQueCero() {
        assertThrows(IllegalArgumentException.class, () ->
                new Articulo(1L, 10, -1.0, "Cargador", 20.0)
        );
    }

    @Test
    void noDebePermitirDtoMayorQue100() {
        assertThrows(IllegalArgumentException.class, () ->
                new Articulo(1L, 10, 150.0, "Pantalla", 120.0)
        );
    }
}