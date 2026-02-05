package com.belgem.backend.application.service.articulo;

import com.belgem.backend.domain.exception.ArticuloNoEncontradoException;
import com.belgem.backend.domain.model.Articulo;
import com.belgem.backend.domain.port.input.ActualizarArticuloUseCase;
import com.belgem.backend.domain.port.output.ArticuloRepositoryPort;
import org.springframework.stereotype.Service;

@Service
public class ActualizarArticuloService implements ActualizarArticuloUseCase {
    private final ArticuloRepositoryPort repo;

    public ActualizarArticuloService(ArticuloRepositoryPort repo) {
        this.repo = repo;
    }

    @Override
    public Articulo actualizar(Long id, Articulo datos) {

        Articulo existente = repo.findById(id)
                .orElseThrow(() -> new ArticuloNoEncontradoException(id));

        // Validar nombre duplicado
        if (!existente.getNombre().equals(datos.getNombre()) &&
                repo.existsByNombre(datos.getNombre())) {

            throw new IllegalArgumentException("Ya existe un artículo con ese nombre");
        }
        Articulo actualizado = new Articulo(
                id,
                datos.getNombre(),
                datos.getSituacion(),
                datos.getPvpMinimo(),
                datos.getPesoKg(),
                datos.getAltoCm(),
                datos.getAnchoCm(),
                datos.getLargoCm(),
                datos.getVendible()
        );
        return repo.save(actualizado);
    }
}
