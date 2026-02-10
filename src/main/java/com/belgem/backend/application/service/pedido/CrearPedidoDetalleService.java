package com.belgem.backend.application.service.pedido;

import com.belgem.backend.domain.model.Pedido;
import com.belgem.backend.domain.model.PedidoDetalle;
import com.belgem.backend.domain.port.input.CrearPedidoDetalleUseCase;
import com.belgem.backend.domain.port.output.ArticuloRepositoryPort;
import com.belgem.backend.domain.port.output.PedidoDetalleRepositoryPort;
import com.belgem.backend.domain.port.output.PedidoRepositoryPort;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CrearPedidoDetalleService implements CrearPedidoDetalleUseCase {

    private final PedidoDetalleRepositoryPort detalleRepo;
    private final PedidoRepositoryPort pedidoRepo;
    private final ArticuloRepositoryPort articuloRepo;

    public CrearPedidoDetalleService(PedidoDetalleRepositoryPort detalleRepo,
                                     PedidoRepositoryPort pedidoRepo,
                                     ArticuloRepositoryPort articuloRepo) {
        this.detalleRepo = detalleRepo;
        this.pedidoRepo = pedidoRepo;
        this.articuloRepo = articuloRepo;
    }

    @Override
    public PedidoDetalle create(PedidoDetalle detalle) {

        if (detalle == null) {
            throw new IllegalArgumentException("Order line must not be null");
        }
        if (detalle.getPedidoId() == null) {
            throw new IllegalArgumentException("Order id must not be null");
        }
        if (detalle.getArticuloId() == null) {
            throw new IllegalArgumentException("Article id must not be null");
        }
        if (detalle.getCantidad() == null || detalle.getCantidad() <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than 0");
        }
        if (detalle.getPrecioUnitario() == null || detalle.getPrecioUnitario().compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Unit price must be greater than or equal to 0");
        }

        if (!pedidoRepo.existsById(detalle.getPedidoId())) {
            throw new IllegalArgumentException("Order not found: " + detalle.getPedidoId());
        }
        if (!articuloRepo.existsById(detalle.getArticuloId())) {
            throw new IllegalArgumentException("Article not found: " + detalle.getArticuloId());
        }

        BigDecimal subtotal = detalle.getPrecioUnitario()
                .multiply(BigDecimal.valueOf(detalle.getCantidad()));
        detalle.setSubtotal(subtotal);

        PedidoDetalle saved = detalleRepo.save(detalle);

        BigDecimal newTotal = detalleRepo.sumSubtotalByPedidoId(detalle.getPedidoId());

        Pedido pedido = pedidoRepo.findById(detalle.getPedidoId())
                .orElseThrow(() -> new IllegalArgumentException("Order not found: " + detalle.getPedidoId()));

        pedido.setTotal(newTotal);
        pedidoRepo.save(pedido);

        return saved;
    }
}