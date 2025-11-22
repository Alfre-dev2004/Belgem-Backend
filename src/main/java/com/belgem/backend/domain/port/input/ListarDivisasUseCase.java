package com.belgem.backend.domain.port.input;
import java.util.List;
import com.belgem.backend.domain.model.Divisa;

/**
 * Caso de uso para listar todas las divisas disponibles en el sistema.
 */
public interface ListarDivisasUseCase {
    List<Divisa> listar();
}
