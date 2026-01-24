package com.belgem.backend.infrastructure.adapter.input.web;

import com.belgem.backend.application.dto.pedido.ActualizarEstadoRequest;
import com.belgem.backend.application.dto.pedido.CrearPedidoRequest;
import com.belgem.backend.domain.model.Pedido;
import com.belgem.backend.domain.port.input.ActualizarPedidoUseCase;
import com.belgem.backend.domain.port.input.CrearPedidoUseCase;
import com.belgem.backend.domain.port.input.EliminarPedidoUseCase;
import com.belgem.backend.domain.port.input.ListarPedidoUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final CrearPedidoUseCase crearPedido;
    private final ListarPedidoUseCase listarPedidos;
    private final ActualizarPedidoUseCase actualizarPedido;
    private final EliminarPedidoUseCase eliminarPedido;

    public PedidoController(CrearPedidoUseCase crearPedido,
                            ListarPedidoUseCase listarPedidos,
                            ActualizarPedidoUseCase actualizarPedido,
                            EliminarPedidoUseCase eliminarPedido)
    {
        this.crearPedido = crearPedido;
        this.listarPedidos = listarPedidos;
        this.actualizarPedido = actualizarPedido;
        this.eliminarPedido = eliminarPedido;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pedido crear(@RequestBody CrearPedidoRequest req) {
        Pedido pedido = Pedido.nuevo(
                req.getClienteId(),
                req.getRepresentanteId(),
                req.getObservaciones()
        );
        return crearPedido.create(pedido);
    }

    @GetMapping
    public List<Pedido> listar() {
        return listarPedidos.findAll();
    }

    @PatchMapping("/{id}/estado")
    public Pedido actualizarEstado(@PathVariable Long id, @RequestBody ActualizarEstadoRequest req) {
        return actualizarPedido.updateStatus(id, req.getEstado());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        eliminarPedido.deleteById(id);
    }
}
