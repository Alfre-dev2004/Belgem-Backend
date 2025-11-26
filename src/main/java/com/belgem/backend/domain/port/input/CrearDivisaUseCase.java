package com.belgem.backend.domain.port.input;
/**
 * Caso de uso para crear una nueva divisa en el sistema.
 */
import com.belgem.backend.domain.model.Divisa;

public interface CrearDivisaUseCase {
    Divisa crear(Divisa divisa);
}
