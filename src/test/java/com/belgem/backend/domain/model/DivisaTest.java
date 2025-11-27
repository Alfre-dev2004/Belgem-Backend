package com.belgem.backend.domain.model;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests de unidad para la clase de dominio Divisa.
 * Aquí solo probamos el constructor y las validaciones básicas.
 * No depende de Spring ni de BD (dominio puro).
 */

public class DivisaTest {
    @Test
    void noDebePermitirCodigoVacio(){
        assertThrows(IllegalArgumentException.class, () ->
                new Divisa(1L,"","Euro")
        );
    }

    @Test
    void noDebePermitirNombreVacio(){
        assertThrows(IllegalArgumentException.class, () ->
                new Divisa(1L,"EUR","")
        );
    }

    @Test
    void debeCrearDivisaValida(){
        Long id = 1L;
        String code = "EUR";
        String name = "EURO";

        Divisa divisa = new Divisa(id,code,name);
        assertEquals(id, divisa.getId());
        assertEquals(code, divisa.getCode());
        assertEquals(name, divisa.getName());
    }
}
