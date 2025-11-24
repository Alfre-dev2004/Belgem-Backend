package com.belgem.backend.domain.port.input;

import com.belgem.backend.domain.model.Cliente;

/**
 * Puerto de entrada (Input Port) para el caso de uso de actualización de cliente.
 * Es implementada por la capa APPLICATION, que contiene la lógica de cada caso de uso.
 */
public interface ActualizarClienteUseCase {

    Cliente actualizarCliente(Long id, Cliente clienteActualizado);

}
