package com.belgem.backend.infrastructure.adapter.input.web;

import com.belgem.backend.application.dto.articulo.ActualizarArticuloRequest;
import com.belgem.backend.application.dto.articulo.ArticuloResponse;
import com.belgem.backend.application.dto.articulo.CrearArticuloRequest;
import com.belgem.backend.domain.port.input.*;
import com.belgem.backend.infrastructure.mapper.ArticuloMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * Controlador REST para gestionar artículos.
 * <p>
 * Esta clase forma parte de la capa de entrada (web) y orquesta
 * los casos de uso del dominio.
 * </p>
 */
@RestController
@RequestMapping("/articulos")
public class ArticuloController {

    private final CrearArticuloUseCase crearUC;
    private final ActualizarArticuloUseCase actualizarUC;
    private final ListarArticulosUseCase listarUC;
    private final EliminarArticuloUseCase eliminarUC;
    private final BuscarArticuloPorNombreUseCase buscarPorNombreUC;
    private final ArticuloMapper mapper;

    public ArticuloController(
            CrearArticuloUseCase crearUC,
            ActualizarArticuloUseCase actualizarUC,
            ListarArticulosUseCase listarUC,
            EliminarArticuloUseCase eliminarUC,
            BuscarArticuloPorNombreUseCase buscarPorNombreUC,
            ArticuloMapper mapper
    ) {
        this.crearUC = crearUC;
        this.actualizarUC = actualizarUC;
        this.listarUC = listarUC;
        this.eliminarUC = eliminarUC;
        this.buscarPorNombreUC = buscarPorNombreUC;
        this.mapper = mapper;
    }

    /**
     * POST /articulos
     *
     * Crea un nuevo artículo.
     */
    @PostMapping
    public ArticuloResponse crear(@RequestBody CrearArticuloRequest request) {
        return mapper.toResponse(
                crearUC.crear(mapper.toDomain(request))
        );
    }

    /**
     * GET /articulos
     *
     * Devuelve la lista completa de artículos.
     * Convertimos la lista del dominio a DTO antes de responder.
     */
    @GetMapping
    public List<ArticuloResponse> listar() {
        return listarUC.listar()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    /**
     * GET /articulos/{id}
     *
     * Obtiene un artículo por su identificador.
     */
    @GetMapping("/{id}")
    public ArticuloResponse buscarPorId(@PathVariable Long id) {
        return listarUC.listar()
                .stream()
                .filter(a -> a.getId().equals(id))
                .findFirst()
                .map(mapper::toResponse)
                .orElseThrow(() -> new RuntimeException("Artículo no encontrado"));
    }

    /**
     * GET /articulos/buscar?nombre=xxx
     *
     * Busca artículos cuyo nombre contenga la cadena proporcionada.
     */
    @GetMapping("/buscar")
    public List<ArticuloResponse> buscarPorNombre(@RequestParam String nombre) {
        return buscarPorNombreUC.buscarPorNombre(nombre)
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    /**
     * PUT /articulos/{id}
     *
     * Actualiza un artículo existente.
     */
    @PutMapping("/{id}")
    public ArticuloResponse actualizar(
            @PathVariable Long id,
            @RequestBody ActualizarArticuloRequest request
    ) {
        return mapper.toResponse(
                actualizarUC.actualizar(id, mapper.toDomain(request, id))
        );
    }

    /**
     * DELETE /articulos/{id}
     *
     * Elimina un artículo por su identificador.
     */
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        eliminarUC.eliminar(id);
    }
}
