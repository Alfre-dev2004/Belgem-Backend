package com.belgem.backend.domain.port.input;

import com.belgem.backend.domain.model.Divisa;

/**
 * Caso de uso para obtener una divisa por su ID.
 * Es un puerto de entrada del dominio: define lo que el negocio ofrece al exterior.
 */
public interface ObtenerDivisaPorIdUseCase {

    /**
     * Obtiene una divisa por su identificador único.
     *
     * @param id identificador de la divisa
     * @return la divisa encontrada
     * @throws RuntimeException si no existe ninguna divisa con ese id
     */
    Divisa obtener(Long id);
}
