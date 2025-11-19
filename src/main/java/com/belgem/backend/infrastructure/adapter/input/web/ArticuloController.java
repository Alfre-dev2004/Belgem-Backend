package com.belgem.backend.infrastructure.adapter.input.web;

import com.belgem.backend.domain.model.Articulo;
import com.belgem.backend.domain.port.input.GestionarArticuloUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/articulos")
public class ArticuloController {

    private final GestionarArticuloUseCase gestionarArticuloUseCase;

    public ArticuloController(GestionarArticuloUseCase gestionarArticuloUseCase) {
        this.gestionarArticuloUseCase = gestionarArticuloUseCase;
    }

    @GetMapping
    public List<Articulo> listarArticulos() {
        return gestionarArticuloUseCase.listar();
    }

    @PostMapping
    public ResponseEntity<Articulo> crearArticulo(@RequestBody Articulo articulo) {
        Articulo nuevoArticulo = gestionarArticuloUseCase.guardar(articulo);
        return new ResponseEntity<>(nuevoArticulo, HttpStatus.CREATED);
    }

    @PutMapping("/{articuloId}")
    public ResponseEntity<Articulo> actualizarArticulo(
            @PathVariable Long articuloId,
            @RequestBody Articulo datos) {

        Articulo articuloActualizado = gestionarArticuloUseCase.actualizar(articuloId, datos);
        return ResponseEntity.ok(articuloActualizado);
    }

    @DeleteMapping("/{articuloId}")
    public ResponseEntity<Void> eliminarArticulo(@PathVariable Long articuloId) {
        gestionarArticuloUseCase.eliminar(articuloId);
        return ResponseEntity.noContent().build();
    }
}