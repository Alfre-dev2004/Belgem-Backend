package com.belgem.backend.infrastructure.adapter.input.web;

import com.belgem.backend.application.dto.pedido.CrearPedidoDetalleRequest;
import com.belgem.backend.domain.model.PedidoDetalle;
import com.belgem.backend.domain.port.input.CrearPedidoDetalleUseCase;
import com.belgem.backend.domain.port.input.ListarPedidoDetalleUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pedidos/{pedidoId}/detalles")
public class PedidoDetalleController {

    private final CrearPedidoDetalleUseCase crearPedidoDetalle;
    private final ListarPedidoDetalleUseCase listarPedidoDetalle;

    public PedidoDetalleController(CrearPedidoDetalleUseCase crearPedidoDetalle, ListarPedidoDetalleUseCase listarPedidoDetalle) {
        this.crearPedidoDetalle = crearPedidoDetalle;
        this.listarPedidoDetalle = listarPedidoDetalle;
    }

    @GetMapping
    public List<PedidoDetalle> listar(@PathVariable Long pedidoId) {
        return listarPedidoDetalle.listarPorPedidoId(pedidoId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PedidoDetalle crear(@PathVariable Long pedidoId, @RequestBody CrearPedidoDetalleRequest req) {

        PedidoDetalle detalle = PedidoDetalle.nuevo(
                pedidoId,
                req.getArticuloId(),
                req.getCantidad(),
                req.getPrecioUnitario()
        );

        return crearPedidoDetalle.create(detalle);
    }
}