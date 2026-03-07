package com.belgem.backend.infrastructure.adapter.input.web;

import com.belgem.backend.application.dto.StockAlmacen.CrearStockAlmacenRequest;
import com.belgem.backend.application.dto.StockAlmacen.StockAlmacenResponse;
import com.belgem.backend.domain.model.StockAlmacen;
import com.belgem.backend.infrastructure.mapper.StockAlmacenMapper;

// Use cases (ajusta nombres si los tienes distintos)
import com.belgem.backend.application.service.StockAlmacen.CrearStockAlmacenService;
import com.belgem.backend.application.service.StockAlmacen.ListarStockAlmacenService;
import com.belgem.backend.application.service.StockAlmacen.ObtenerStockAlmacenPorIdService;
import com.belgem.backend.application.service.StockAlmacen.EliminarStockAlmacenService;
import com.belgem.backend.application.service.StockAlmacen.ObtenerStockPorArticuloYAlmacenService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller REST para gestionar el stock por almacén.
 *
 * Este controller:
 * - Recibe DTOs (request)
 * - Usa servicios / casos de uso (application)
 * - Devuelve DTOs (response)
 */
@RestController
@RequestMapping("/api/v1/stock_almacen")
public class StockAlmacenController {

    private final CrearStockAlmacenService crearStockAlmacenService;
    private final ListarStockAlmacenService listarStockAlmacenService;
    private final ObtenerStockAlmacenPorIdService obtenerStockAlmacenPorIdService;
    private final EliminarStockAlmacenService eliminarStockAlmacenService;
    private final ObtenerStockPorArticuloYAlmacenService obtenerStockPorArticuloYAlmacenService;

    public StockAlmacenController(
            CrearStockAlmacenService crearStockAlmacenService,
            ListarStockAlmacenService listarStockAlmacenService,
            ObtenerStockAlmacenPorIdService obtenerStockAlmacenPorIdService,
            EliminarStockAlmacenService eliminarStockAlmacenService,
            ObtenerStockPorArticuloYAlmacenService obtenerStockPorArticuloYAlmacenService
    ) {
        this.crearStockAlmacenService = crearStockAlmacenService;
        this.listarStockAlmacenService = listarStockAlmacenService;
        this.obtenerStockAlmacenPorIdService = obtenerStockAlmacenPorIdService;
        this.eliminarStockAlmacenService = eliminarStockAlmacenService;
        this.obtenerStockPorArticuloYAlmacenService = obtenerStockPorArticuloYAlmacenService;
    }

    /**
     * Crear stock para un artículo en un almacén.
     * Normalmente se usará cuando un artículo se registra por primera vez en un almacén.
     */
    @PostMapping
    public ResponseEntity<StockAlmacenResponse> crear(@RequestBody CrearStockAlmacenRequest request) {
        StockAlmacen domain = StockAlmacenMapper.toDomain(request);
        StockAlmacen creado = crearStockAlmacenService.crear(domain);
        return ResponseEntity.ok(StockAlmacenMapper.toResponse(creado));
    }

    /**
     * Listar todo el stock almacenado.
     */
    @GetMapping
    public ResponseEntity<List<StockAlmacenResponse>> listarTodo() {
        List<StockAlmacen> lista = listarStockAlmacenService.listarTodo();
        List<StockAlmacenResponse> response = lista.stream()
                .map(StockAlmacenMapper::toResponse)
                .toList();
        return ResponseEntity.ok(response);
    }

    /**
     * Buscar un stock por ID.
     */
    @GetMapping("/{id}")
    public ResponseEntity<StockAlmacenResponse> obtenerPorId(@PathVariable Long id) {
        StockAlmacen stock = obtenerStockAlmacenPorIdService.obtenerPorId(id);
        return ResponseEntity.ok(StockAlmacenMapper.toResponse(stock));
    }

    /**
     * Buscar un stock por artículo + almacén (lo más importante para MovimientoStock).
     */
    @GetMapping("/articulo/{articuloId}/almacen/{almacenId}")
    public ResponseEntity<StockAlmacenResponse> obtenerPorArticuloYAlmacen(
            @PathVariable Long articuloId,
            @PathVariable Long almacenId
    ) {
        StockAlmacen stock = obtenerStockPorArticuloYAlmacenService.obtener(articuloId, almacenId);
        return ResponseEntity.ok(StockAlmacenMapper.toResponse(stock));
    }

    /**
     * Listar stock por artículo (en todos los almacenes).
     */
    @GetMapping("/articulo/{articuloId}")
    public ResponseEntity<List<StockAlmacenResponse>> listarPorArticulo(@PathVariable Long articuloId) {
        List<StockAlmacen> lista = listarStockAlmacenService.listarPorArticulo(articuloId);
        List<StockAlmacenResponse> response = lista.stream()
                .map(StockAlmacenMapper::toResponse)
                .toList();
        return ResponseEntity.ok(response);
    }

    /**
     * Listar stock por almacén (todos los artículos dentro de ese almacén).
     */
    @GetMapping("/almacen/{almacenId}")
    public ResponseEntity<List<StockAlmacenResponse>> listarPorAlmacen(@PathVariable Long almacenId) {
        List<StockAlmacen> lista = listarStockAlmacenService.listarPorAlmacen(almacenId);
        List<StockAlmacenResponse> response = lista.stream()
                .map(StockAlmacenMapper::toResponse)
                .toList();
        return ResponseEntity.ok(response);
    }

    /**
     * Eliminar un registro StockAlmacen por ID.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        eliminarStockAlmacenService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
