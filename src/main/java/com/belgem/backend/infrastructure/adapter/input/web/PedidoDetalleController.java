package com.belgem.backend.infrastructure.adapter.input.web;

import com.belgem.backend.application.dto.pedido.CrearPedidoDetalleRequest;
import com.belgem.backend.domain.model.PedidoDetalle;
import com.belgem.backend.domain.port.input.CrearPedidoDetalleUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedidos/{pedidoId}/detalles")
public class PedidoDetalleController {

    private final CrearPedidoDetalleUseCase crearPedidoDetalle;

    public PedidoDetalleController(CrearPedidoDetalleUseCase crearPedidoDetalle) {
        this.crearPedidoDetalle = crearPedidoDetalle;
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