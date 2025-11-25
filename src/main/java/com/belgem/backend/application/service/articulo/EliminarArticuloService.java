package com.belgem.backend.application.service.articulo;

import com.belgem.backend.domain.exception.ArticuloNoEncontradoException;
import com.belgem.backend.domain.port.input.EliminarArticuloUseCase;
import com.belgem.backend.domain.port.output.ArticuloRepositoryPort;
import org.springframework.stereotype.Service;

@Service
public class EliminarArticuloService implements EliminarArticuloUseCase {

    private final ArticuloRepositoryPort repo;

    public EliminarArticuloService(ArticuloRepositoryPort repo) {
        this.repo = repo;
    }

    @Override
    public void eliminar(Long id) {

        if (!repo.existsById(id)) {
            throw new ArticuloNoEncontradoException(id);
        }

        repo.deleteById(id);
    }
}