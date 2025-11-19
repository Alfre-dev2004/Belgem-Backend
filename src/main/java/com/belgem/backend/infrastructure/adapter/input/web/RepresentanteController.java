package com.belgem.backend.infrastructure.adapter.input.web;

import com.belgem.backend.domain.model.Representante;
import com.belgem.backend.domain.port.input.GestionarRepresentanteUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/representantes")
public class RepresentanteController {

    private final GestionarRepresentanteUseCase gestionarRepresentanteUseCase;

    public RepresentanteController(GestionarRepresentanteUseCase gestionarRepresentanteUseCase) {
        this.gestionarRepresentanteUseCase = gestionarRepresentanteUseCase;
    }

    @GetMapping
    public List<Representante> listarRepresentantes() {
        return gestionarRepresentanteUseCase.listar();
    }

    @GetMapping("/{representanteId}")
    public ResponseEntity<Representante> obtenerRepresentante(@PathVariable Long representanteId) {
        return ResponseEntity.ok(gestionarRepresentanteUseCase.obtenerPorId(representanteId));
    }

    @PostMapping
    public ResponseEntity<Representante> crearRepresentante(@RequestBody Representante representante) {
        Representante guardado = gestionarRepresentanteUseCase.guardar(representante);
        return new ResponseEntity<>(guardado, HttpStatus.CREATED);
    }

    @PutMapping("/{representanteId}")
    public ResponseEntity<Representante> actualizarRepresentante(@PathVariable Long representanteId, @RequestBody Representante data) {
        return ResponseEntity.ok(gestionarRepresentanteUseCase.actualizar(representanteId, data));
    }

    @DeleteMapping("/{representanteId}")
    public ResponseEntity<Void> eliminarRepresentante(@PathVariable Long representanteId) {
        gestionarRepresentanteUseCase.eliminar(representanteId);
        return ResponseEntity.noContent().build();
    }
}