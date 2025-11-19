package com.belgem.backend.controller;

import com.belgem.backend.domain.model.Representante;
import com.belgem.backend.service.RepresentanteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/representantes")  // URL base para todos los endpoints
public class RepresentanteController {

    private final RepresentanteService service;

    public RepresentanteController(RepresentanteService service) {
        this.service = service;
    }

    // listar todos los representantes
    @GetMapping
    public List<Representante> listar() {
        return service.listar();
    }

    //  obtener un representante por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Representante> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(service.obtenerPorId(id));
    }

    // crear un nuevo representante
    @PostMapping
    public ResponseEntity<Representante> crear(@RequestBody Representante rep) {
        Representante guardado = service.guardar(rep);
        return ResponseEntity.ok(guardado);
    }

    //actualizar un representante existente
    @PutMapping("/{id}")
    public ResponseEntity<Representante> actualizar(@PathVariable Long id, @RequestBody Representante rep) {
        return ResponseEntity.ok(service.actualizar(id, rep));
    }

    // eliminar un representante por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
