package com.belgem.backend.domain.port.input;

import com.belgem.backend.domain.model.Cliente;

/**
 * Caso de uso para OBTENER un cliente por su ID.
 * Esta interfaz define la operación que permite buscar
 * un cliente específico dentro del dominio usando su identificador.
 */
public interface ObtenerClientePorIdUseCase {
    Cliente obtenerPorId(Long id);
}