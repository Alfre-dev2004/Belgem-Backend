package com.belgem.backend.infrastructure.adapter.in.web;

import com.belgem.backend.domain.model.Cliente;
import com.belgem.backend.domain.port.in.GestionarClienteUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
// Aplicamos el versionamiento de API que planeamos
@RequestMapping("/api/v1/clientes")
public class ClienteController {

    // Se inyecta el Input Port (Caso de Uso) del Dominio, en lugar del Service concreto
    private final GestionarClienteUseCase gestionarClienteUseCase;

    public ClienteController(GestionarClienteUseCase gestionarClienteUseCase) {
        this.gestionarClienteUseCase = gestionarClienteUseCase;
    }

    @GetMapping
    public List<Cliente> listarClientes() {
        // Delega la lógica de listado al Puerto de Entrada
        return gestionarClienteUseCase.listar();
    }

    @PostMapping
    public ResponseEntity<Cliente> crearCliente(@RequestBody Cliente cliente) {
        // Delega la creación al Puerto de Entrada
        Cliente nuevoCliente = gestionarClienteUseCase.crear(cliente);
        // Devuelve 201 Created (buena práctica REST)
        return new ResponseEntity<>(nuevoCliente, HttpStatus.CREATED);
    }

    @PutMapping("/{clienteId}")
    public ResponseEntity<Cliente> actualizarCliente(
            @PathVariable Long clienteId,
            @RequestBody Cliente datos) {

        // Delega la actualización al Puerto de Entrada, usando el ID estandarizado
        Cliente clienteActualizado = gestionarClienteUseCase.actualizar(clienteId, datos);
        return ResponseEntity.ok(clienteActualizado);
    }

    @DeleteMapping("/{clienteId}")
    public ResponseEntity<Void> eliminarCliente(@PathVariable Long clienteId) {
        // Delega la eliminación al Puerto de Entrada, usando el ID estandarizado
        gestionarClienteUseCase.eliminar(clienteId);
        // Devuelve 204 No Content (buena práctica REST)
        return ResponseEntity.noContent().build();
    }
}