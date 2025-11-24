package com.belgem.backend.domain.port.input;

import com.belgem.backend.domain.model.Representante;
import java.util.List;

/**
 * Puerto de entrada para listar todos los Representantes.
 *
 * Permite obtener la lista completa de representantes
 * registrados en el sistema.
 */
public interface ListarRepresentantesUseCase {
    List<Representante> listar();
}
