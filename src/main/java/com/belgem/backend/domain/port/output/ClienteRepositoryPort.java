package com.belgem.backend.domain.port.output;

import com.belgem.backend.domain.model.Cliente;

import java.util.List;
import java.util.Optional;

/**
 *  Puerto de salida (Output Port) para el acceso a la persistencia de clientes.
 *  Este puerto define las operaciones que la capa DOMAIN necesita que
 *  la infraestructura implemente para trabajar con clientes en la base de datos.
 */
public interface ClienteRepositoryPort {

    // Guarda un cliente en la persistencia.
    // Se usa tanto para crear como para actualizar.
    Cliente save(Cliente cliente);

    //Busca un cliente por su ID.
    Optional<Cliente> findById(Long id);

    // Devuelve todos los clientes almacenados.
    List<Cliente> findAll();

    //Verifica si existe un cliente con un ID específico
    boolean existsById(Long id);

    //Elimina un cliente utilizando su ID.
    void deleteById(Long id);
}
