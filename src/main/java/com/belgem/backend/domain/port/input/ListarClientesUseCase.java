package com.belgem.backend.domain.port.input;

import com.belgem.backend.domain.model.Cliente;
import java.util.List;

/**
 *  Caso de uso para LISTAR todos los clientes.
 *  Esta interfaz define la operación que permite obtener
 *  una lista completa de clientes desde la capa de dominio.
 */
public interface ListarClientesUseCase {
    List<Cliente> listarClientes();
}

