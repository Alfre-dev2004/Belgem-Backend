package com.belgem.backend.controller;

import com.belgem.backend.entity.Cliente;
import com.belgem.backend.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST del módulo Cliente.
 *
 * Expone los endpoints CRUD (/api/v1/clientes) para gestionar
 * los registros de clientes desde el frontend o Postman.
 *
 * Utiliza {@link ClienteService} para ejecutar la lógica de negocio.
 */
@RestController
@RequestMapping("/cliente")
@CrossOrigin(origins = "*")
public class ClienteController {

    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @GetMapping
    public List<Cliente> listar() {
        return service.listar();
    }

    @PostMapping
    public ResponseEntity<Cliente> crear(@RequestBody Cliente cliente) {
        return new ResponseEntity<>(service.crear(cliente), HttpStatus.CREATED);
    }

    /** Actualiza un cliente existente por su ID. */
    @PutMapping("/{id}")
    public Cliente actualizar(@PathVariable Long id, @RequestBody Cliente cliente) {
        return service.actualizar(id, cliente);
    }

    /** Elimina un cliente por su ID. */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}
