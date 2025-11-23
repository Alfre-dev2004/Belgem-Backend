package com.belgem.backend.infrastructure.adapter.input.web;

import com.belgem.backend.application.dto.divisa.ActualizarDivisaRequest;
import com.belgem.backend.application.dto.divisa.CrearDivisaRequest;
import com.belgem.backend.application.dto.divisa.DivisaResponse;
import com.belgem.backend.domain.model.Divisa;
import com.belgem.backend.domain.port.input.ActualizarDivisaUseCase;
import com.belgem.backend.domain.port.input.CrearDivisaUseCase;
import com.belgem.backend.domain.port.input.EliminarDivisaUseCase;
import com.belgem.backend.domain.port.input.ListarDivisasUseCase;
import com.belgem.backend.domain.port.input.ObtenerDivisaPorIdUseCase;
import com.belgem.backend.infrastructure.mapper.DivisaMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/divisas")
public class DivisaController {

    private final CrearDivisaUseCase crearDivisa;
    private final ListarDivisasUseCase listarDivisas;
    private final ActualizarDivisaUseCase actualizarDivisa;
    private final EliminarDivisaUseCase eliminarDivisa;
    private final ObtenerDivisaPorIdUseCase obtenerDivisaPorId;
    private final DivisaMapper mapper;

    public DivisaController(
            CrearDivisaUseCase crearDivisa,
            ListarDivisasUseCase listarDivisas,
            ActualizarDivisaUseCase actualizarDivisa,
            EliminarDivisaUseCase eliminarDivisa,
            ObtenerDivisaPorIdUseCase obtenerDivisaPorId,
            DivisaMapper mapper
    ) {
        this.crearDivisa = crearDivisa;
        this.listarDivisas = listarDivisas;
        this.actualizarDivisa = actualizarDivisa;
        this.eliminarDivisa = eliminarDivisa;
        this.obtenerDivisaPorId = obtenerDivisaPorId;
        this.mapper = mapper;
    }

    // GET /divisas
    @GetMapping
    public List<DivisaResponse> getAll() {
        List<Divisa> divisas = listarDivisas.listar();
        return divisas.stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }

    // GET /divisas/{id}
    @GetMapping("/{id}")
    public ResponseEntity<DivisaResponse> obtenerPorId(@PathVariable Long id) {
        Divisa divisa = obtenerDivisaPorId.obtener(id);
        DivisaResponse response = mapper.toResponse(divisa);
        return ResponseEntity.ok(response);
    }

    // POST /divisas
    @PostMapping
    public ResponseEntity<DivisaResponse> crear(@RequestBody CrearDivisaRequest request) {
        Divisa divisa = mapper.toDomain(request);
        Divisa creada = crearDivisa.crear(divisa);
        DivisaResponse response = mapper.toResponse(creada);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // PUT /divisas/{id}
    @PutMapping("/{id}")
    public ResponseEntity<DivisaResponse> actualizar(
            @PathVariable Long id,
            @RequestBody ActualizarDivisaRequest request
    ) {
        Divisa datos = mapper.toDomain(id, request);
        Divisa actualizada = actualizarDivisa.actualizar(id, datos);
        DivisaResponse response = mapper.toResponse(actualizada);
        return ResponseEntity.ok(response);
    }

    // DELETE /divisas/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        eliminarDivisa.eliminarDivisa(id);
        return ResponseEntity.noContent().build();
    }
}
