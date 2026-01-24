package com.belgem.backend.infrastructure.adapter.input.web;

import com.belgem.backend.application.dto.tipoMovimiento.ActualizarTipoMovimientoRequest;
import com.belgem.backend.application.dto.tipoMovimiento.CrearTipoMovimientoRequest;
import com.belgem.backend.application.dto.tipoMovimiento.TipoMovimientoResponse;
import com.belgem.backend.domain.port.input.ActualizarTipoMovimientoUseCase;
import com.belgem.backend.domain.port.input.CrearTipoMovimientoUseCase;
import com.belgem.backend.domain.port.input.EliminarTipoMovimientoUseCase;
import com.belgem.backend.domain.port.input.ListarTipoMovimientoUseCase;
import com.belgem.backend.domain.port.input.ObtenerTipoMovimientoUseCase;
import com.belgem.backend.domain.model.TipoMovimiento;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para el catálogo de Tipos de Movimiento.
 * <p>
 * Este controlador depende únicamente de puertos de entrada (UseCases),
 * manteniendo la arquitectura hexagonal.
 * </p>
 */
@RestController
@RequestMapping("/api/v1/tipos-movimiento")
public class TipoMovimientosController {

    private final CrearTipoMovimientoUseCase crear;
    private final ObtenerTipoMovimientoUseCase obtener;
    private final ListarTipoMovimientoUseCase listar;
    private final ActualizarTipoMovimientoUseCase actualizar;
    private final EliminarTipoMovimientoUseCase eliminar;

    public TipoMovimientosController(
            CrearTipoMovimientoUseCase crear,
            ObtenerTipoMovimientoUseCase obtener,
            ListarTipoMovimientoUseCase listar,
            ActualizarTipoMovimientoUseCase actualizar,
            EliminarTipoMovimientoUseCase eliminar
    ) {
        this.crear = crear;
        this.obtener = obtener;
        this.listar = listar;
        this.actualizar = actualizar;
        this.eliminar = eliminar;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TipoMovimientoResponse crear(@RequestBody CrearTipoMovimientoRequest request) {
        TipoMovimiento creado = crear.crear(
                new TipoMovimiento(null, request.getNombre(), request.getDescripcion())
        );
        return toResponse(creado);
    }

    @GetMapping("/{id}")
    public TipoMovimientoResponse obtener(@PathVariable Long id) {
        return toResponse(obtener.obtener(id));
    }

    @GetMapping
    public List<TipoMovimientoResponse> listar() {
        return listar.listar().stream().map(this::toResponse).toList();
    }

    @PutMapping("/{id}")
    public TipoMovimientoResponse actualizar(
            @PathVariable Long id,
            @RequestBody ActualizarTipoMovimientoRequest request)  {
        TipoMovimiento actualizado = actualizar.actualizar(
                id,
                new TipoMovimiento(id, request.getNombre(), request.getDescripcion())
        );
        return toResponse(actualizado);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        eliminar.eliminar(id);
    }



    private TipoMovimientoResponse toResponse(TipoMovimiento d) {
        TipoMovimientoResponse res = new TipoMovimientoResponse();
        res.setId(d.getId());
        res.setNombre(d.getNombre());
        res.setDescripcion(d.getDescripcion());
        return res;
    }
}
