package com.belgem.backend.infrastructure.adapter.input.web;

import com.belgem.backend.domain.model.Divisas;
import com.belgem.backend.domain.port.input.GestionarDivisasUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/divisas")
public class DivisasController {

    private final GestionarDivisasUseCase gestionarDivisasUseCase;

    public DivisasController(GestionarDivisasUseCase gestionarDivisasUseCase) {
        this.gestionarDivisasUseCase = gestionarDivisasUseCase;
    }

    @GetMapping
    public List<Divisas> listarDivisas() {
        return gestionarDivisasUseCase.listar();
    }

    @GetMapping("/{divisaId}")
    public ResponseEntity<Divisas> obtenerDivisa(@PathVariable Long divisaId) {
        return ResponseEntity.ok(gestionarDivisasUseCase.obtenerPorId(divisaId));
    }

    @PostMapping
    public ResponseEntity<Divisas> crearDivisa(@RequestBody Divisas divisa) {
        Divisas guardada = gestionarDivisasUseCase.guardar(divisa);
        return new ResponseEntity<>(guardada, HttpStatus.CREATED);
    }

    @PutMapping("/{divisaId}")
    public ResponseEntity<Divisas> actualizarDivisa(@PathVariable Long divisaId, @RequestBody Divisas divisa) {
        return ResponseEntity.ok(gestionarDivisasUseCase.actualizar(divisaId, divisa));
    }

    @DeleteMapping("/{divisaId}")
    public ResponseEntity<Void> eliminarDivisa(@PathVariable Long divisaId) {
        gestionarDivisasUseCase.eliminar(divisaId);
        return ResponseEntity.noContent().build();
    }
}