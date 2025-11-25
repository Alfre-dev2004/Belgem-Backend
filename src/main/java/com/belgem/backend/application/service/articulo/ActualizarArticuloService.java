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
    public Articulo actualizar(Long id,Articulo datos){

        repo.findById(id)
                .orElseThrow(() -> new ArticuloNoEncontradoException(id));

        Articulo actualizado = new Articulo(
                id,
                datos.getCantidad(),
                datos.getDto(),
                datos.getNombre(),
                datos.getPrecio()
        );
        return repo.save(actualizado);
    }
}
