package com.belgem.backend.controller;

import com.belgem.backend.domain.model.Divisas;
import com.belgem.backend.application.service.DivisasService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/divisas")
public class DivisasController {

    private final DivisasService divisasService;

    public DivisasController(DivisasService divisasService) {
        this.divisasService = divisasService;
    }

    @GetMapping
    public List<Divisas> listar() {
        return divisasService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Divisas> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(divisasService.obtenerPorId(id));
    }

    @PostMapping
    public ResponseEntity<Divisas> crear(@RequestBody Divisas divisa) {
        Divisas guardada = divisasService.guardar(divisa);
        return ResponseEntity.ok(guardada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Divisas> actualizar(@PathVariable Long id, @RequestBody Divisas divisa) {
        return ResponseEntity.ok(divisasService.actualizar(id, divisa));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        divisasService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
