package com.belgem.backend.controller;

import com.belgem.backend.entity.Divisas;
import com.belgem.backend.service.DivisasService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/divisas")
public class DivisasController {

    private final DivisasService divisaService;

    public DivisasController(DivisasService divisaService) {
        this.divisaService = divisaService;
    }

    @GetMapping
    public List<Divisas> listar() {
        return divisaService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Divisas> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(divisaService.obtenerPorId(id));
    }

    @PostMapping
    public ResponseEntity<Divisas> crear(@RequestBody Divisas divisa) {
        Divisas guardada = divisaService.guardar(divisa);
        return ResponseEntity.ok(guardada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Divisas> actualizar(@PathVariable Long id, @RequestBody Divisas divisa) {
        return ResponseEntity.ok(divisaService.actualizar(id, divisa));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        divisaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
