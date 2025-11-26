package com.belgem.backend.domain.port.input;
import com.belgem.backend.domain.model.Divisa;

/** Caso de uso para actualizar una divisa existente en el sistema. */

public interface ActualizarDivisaUseCase {
    Divisa actualizar(Long id, Divisa nuevaDivisa);
}
