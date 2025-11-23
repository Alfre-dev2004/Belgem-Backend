package com.belgem.backend.domain.port.input;

import com.belgem.backend.domain.model.Cliente;

/**
 *  Caso de uso para CREAR un cliente dentro del dominio.
 *  Esta interfaz define la operación que la aplicación debe permitir:
 *  crear un nuevo cliente usando un objeto de dominio.
 */
public interface CrearClienteUseCase {
    Cliente crearCliente(Cliente cliente);
}

