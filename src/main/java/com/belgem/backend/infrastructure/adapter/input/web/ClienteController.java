package com.belgem.backend.infrastructure.adapter.input.web;

import com.belgem.backend.application.dto.cliente.ActualizarClienteRequest;
import com.belgem.backend.application.dto.cliente.ClienteResponse;
import com.belgem.backend.application.dto.cliente.CrearClienteRequest;
import com.belgem.backend.domain.model.Cliente;
import com.belgem.backend.domain.port.input.*;
import com.belgem.backend.infrastructure.mapper.ClienteMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *  Controlador REST del módulo CLIENTES.
 */
@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final CrearClienteUseCase crear;
    private final ActualizarClienteUseCase actualizar;
    private final ListarClientesUseCase listar;
    private final EliminarClienteUseCase eliminar;
    private final ObtenerClientePorIdUseCase obtener;
    // Mapper encargado de convertir DTO ↔ Dominio ↔ JPA
    private final ClienteMapper mapper;

    public ClienteController(
            CrearClienteUseCase crear,
            ActualizarClienteUseCase actualizar,
            ListarClientesUseCase listar,
            EliminarClienteUseCase eliminar,
            ObtenerClientePorIdUseCase obtener,
            ClienteMapper mapper) {

        this.crear = crear;
        this.actualizar = actualizar;
        this.listar = listar;
        this.eliminar = eliminar;
        this.obtener = obtener;
        this.mapper = mapper;
    }

    /**
     * POST /clientes
     *
     * Crea un nuevo cliente.
     * 1. Recibe un DTO del body.
     * 2. Lo convierte a dominio.
     * 3. Llama al caso de uso de creación.
     * 4. Convierte el resultado a DTO para devolverlo al frontend.
     */
    @PostMapping
    public ClienteResponse crearCliente(@RequestBody CrearClienteRequest req) {
        Cliente cliente = mapper.toDomain(req);
        Cliente creado = crear.crearCliente(cliente);
        return mapper.toResponse(creado);
    }

    /**
     * GET /clientes
     *
     * Devuelve la lista completa de clientes.
     * Siempre convertimos la lista del dominio a DTO antes de responder.
     */
    @GetMapping
    public List<ClienteResponse> listarClientes() {
        return listar.listarClientes()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    /**
     * GET /clientes/{id}
     *
     * Obtiene un cliente por su identificador.
     */
    @GetMapping("/{id}")
    public ClienteResponse obtenerPorId(@PathVariable Long id) {
        Cliente cliente = obtener.obtenerPorId(id);
        return mapper.toResponse(cliente);
    }


    /**
     * PUT /clientes/{id}
     *
     * Actualiza un cliente existente.
     * 1. Recibe el DTO con los datos actualizados.
     * 2. Convierte DTO + id → dominio.
     * 3. Llama al caso de uso de actualización.
     */
    @PutMapping("/{id}")
    public ClienteResponse actualizarCliente(@PathVariable Long id, @RequestBody ActualizarClienteRequest req) {
        Cliente actualizado = actualizar.actualizarCliente(id, mapper.toDomain(id, req));
        return mapper.toResponse(actualizado);
    }

    /**
     * DELETE /clientes/{id}
     *
     * Elimina un cliente por su ID.
     */
    @DeleteMapping("/{id}")
    public void eliminarCliente(@PathVariable Long id) {
        eliminar.eliminarCliente(id);
    }
}

