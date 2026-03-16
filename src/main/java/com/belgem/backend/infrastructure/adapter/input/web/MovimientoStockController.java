package com.belgem.backend.infrastructure.adapter.input.web;

import com.belgem.backend.application.dto.MovimientoStock.CrearMovimientoStockRequest;
import com.belgem.backend.application.dto.MovimientoStock.MovimientoStockResponse;
import com.belgem.backend.application.service.MovimientoStock.ListarMovimientoStockService;
import com.belgem.backend.application.service.MovimientoStock.RegistrarMovimientoStockService;
import com.belgem.backend.domain.model.MovimientoStock;
import com.belgem.backend.infrastructure.mapper.MovimientoStockMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/movimientos-stock")
public class MovimientoStockController {

    private final RegistrarMovimientoStockService registrarService;
    private final ListarMovimientoStockService listarService;

    public MovimientoStockController(RegistrarMovimientoStockService registrarService,
                                     ListarMovimientoStockService listarService) {
        this.registrarService = registrarService;
        this.listarService = listarService;
    }

    @PostMapping
    public ResponseEntity<MovimientoStockResponse> crear(@RequestBody CrearMovimientoStockRequest request) {
        MovimientoStock domain = MovimientoStockMapper.toDomain(request);
        MovimientoStock creado = registrarService.registrar(domain);
        return ResponseEntity.ok(MovimientoStockMapper.toResponse(creado));
    }

    @GetMapping
    public ResponseEntity<List<MovimientoStockResponse>> listarTodo() {
        List<MovimientoStockResponse> response = listarService.listarTodos()
                .stream()
                .map(MovimientoStockMapper::toResponse)
                .toList();

        return ResponseEntity.ok(response);
    }

    @GetMapping("/articulo/{articuloId}")
    public ResponseEntity<List<MovimientoStockResponse>> listarPorArticulo(@PathVariable Long articuloId) {
        List<MovimientoStockResponse> response = listarService.listarPorArticulo(articuloId)
                .stream()
                .map(MovimientoStockMapper::toResponse)
                .toList();

        return ResponseEntity.ok(response);
    }

    @GetMapping("/almacen/{almacenId}")
    public ResponseEntity<List<MovimientoStockResponse>> listarPorAlmacen(@PathVariable Long almacenId) {
        List<MovimientoStockResponse> response = listarService.listarPorAlmacen(almacenId)
                .stream()
                .map(MovimientoStockMapper::toResponse)
                .toList();

        return ResponseEntity.ok(response);
    }
}