package com.belgem.backend.infrastructure.adapter.input.web;

import com.belgem.backend.application.dto.representante.CrearRepresentanteRequest;
import com.belgem.backend.application.dto.representante.ActualizarRepresentanteRequest;
import com.belgem.backend.application.dto.representante.RepresentanteResponse;
import com.belgem.backend.domain.model.Representante;
import com.belgem.backend.domain.port.input.*;
import com.belgem.backend.infrastructure.mapper.RepresentanteMapper;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Controller REST para la gestión de Representantes.
 *
 * Exponde los endpoints para crear, listar, obtener, actualizar y eliminar representantes.
 */
@RestController
@RequestMapping("/representantes")
public class RepresentanteController {

    private final CrearRepresentanteUseCase crearUseCase;
    private final ActualizarRepresentanteUseCase actualizarUseCase;
    private final ListarRepresentantesUseCase listarUseCase;
    private final EliminarRepresentanteUseCase eliminarUseCase;
    private final ObtenerRepresentantePorIdUseCase obtenerUseCase;
    private final RepresentanteMapper mapper;

    public RepresentanteController(
            CrearRepresentanteUseCase crearUseCase,
            ActualizarRepresentanteUseCase actualizarUseCase,
            ListarRepresentantesUseCase listarUseCase,
            EliminarRepresentanteUseCase eliminarUseCase,
            ObtenerRepresentantePorIdUseCase obtenerUseCase,
            RepresentanteMapper mapper
    ) {
        this.crearUseCase = crearUseCase;
        this.actualizarUseCase = actualizarUseCase;
        this.listarUseCase = listarUseCase;
        this.eliminarUseCase = eliminarUseCase;
        this.obtenerUseCase = obtenerUseCase;
        this.mapper = mapper;
    }

    @PostMapping
    public RepresentanteResponse crear(@Valid @RequestBody CrearRepresentanteRequest request) {
        Representante representante = mapper.toDomain(request);
        Representante creado = crearUseCase.crear(representante);
        return mapper.toResponse(creado);
    }

    @GetMapping
    public List<RepresentanteResponse> listar() {
        return listarUseCase.listar()
                .stream()
                .map(mapper::toResponse)
                .toList(); // Cambio recomendado: .toList() en lugar de collect(Collectors.toList())
    }

    @GetMapping("/{id}")
    public RepresentanteResponse obtener(@PathVariable Long id) {
        Representante representante = obtenerUseCase.obtener(id);
        return mapper.toResponse(representante);
    }

    @PutMapping("/{id}")
    public RepresentanteResponse actualizar(
            @PathVariable Long id,
            @Valid @RequestBody ActualizarRepresentanteRequest request
    ) {
        Representante representante = mapper.toDomain(request);
        Representante actualizado = actualizarUseCase.actualizar(id, representante);
        return mapper.toResponse(actualizado);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        eliminarUseCase.eliminar(id);
    }
}
