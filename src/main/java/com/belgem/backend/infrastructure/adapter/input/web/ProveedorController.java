package com.belgem.backend.infrastructure.adapter.input.web;

import com.belgem.backend.application.dto.proveedor.ActualizarProveedorRequest;
import com.belgem.backend.application.dto.proveedor.CrearProveedorRequest;
import com.belgem.backend.application.dto.proveedor.ProveedorResponse;
import com.belgem.backend.domain.port.input.*;
import com.belgem.backend.infrastructure.mapper.ProveedorMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para gestionar proveedores.
 * <p>
 * Esta clase forma parte de la capa de entrada (web) y orquesta
 * los casos de uso del dominio.
 * </p>
 */
@RestController
@RequestMapping("/api/v1/proveedores")
public class ProveedorController {

    private final CrearProveedorUseCase crearUC;
    private final ActualizarProveedorUseCase actualizarUC;
    private final ListarProveedoresUseCase listarUC;
    private final EliminarProveedorUseCase eliminarUC;
    private final ProveedorMapper mapper;

    public ProveedorController(
            CrearProveedorUseCase crearUC,
            ActualizarProveedorUseCase actualizarUC,
            ListarProveedoresUseCase listarUC,
            EliminarProveedorUseCase eliminarUC,
            ProveedorMapper mapper
    ) {
        this.crearUC = crearUC;
        this.actualizarUC = actualizarUC;
        this.listarUC = listarUC;
        this.eliminarUC = eliminarUC;
        this.mapper = mapper;
    }

    /**
     * POST /proveedores
     *
     * Crea un nuevo proveedor.
     */
    @PostMapping
    public ProveedorResponse crear(@RequestBody CrearProveedorRequest request) {
        return mapper.toResponse(
                crearUC.crear(mapper.toDomain(request))
        );
    }

    /**
     * GET /proveedores
     *
     * Devuelve la lista completa de proveedores.
     * Convertimos la lista del dominio a DTO antes de responder.
     */
    @GetMapping
    public List<ProveedorResponse> listar() {
        return listarUC.listar()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    /**
     * GET /proveedores/{id}
     *
     * Obtiene un proveedor por su identificador.
     */
    @GetMapping("/{id}")
    public ProveedorResponse buscarPorId(@PathVariable Long id) {
        return listarUC.listar()
                .stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .map(mapper::toResponse)
                .orElseThrow(() -> new RuntimeException("Proveedor no encontrado"));
    }


    /**
     * PUT /proveedores/{id}
     *
     * Actualiza un proveedor existente.
     */
    @PutMapping("/{id}")
    public ProveedorResponse actualizar(
            @PathVariable Long id,
            @RequestBody ActualizarProveedorRequest request
    ) {
        return mapper.toResponse(
                actualizarUC.actualizar(id, mapper.toDomain(request, id))
        );
    }

    /**
     * DELETE /proveedores/{id}
     *
     * Elimina un proveedor por su identificador.
     */
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        eliminarUC.eliminar(id);
    }
}
