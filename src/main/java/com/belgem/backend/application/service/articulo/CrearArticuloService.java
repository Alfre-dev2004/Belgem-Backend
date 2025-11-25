package com.belgem.backend.application.service.articulo;

import com.belgem.backend.domain.model.Articulo;
import com.belgem.backend.domain.port.input.CrearArticuloUseCase;
import com.belgem.backend.domain.port.output.ArticuloRepositoryPort;
import org.springframework.stereotype.Service;

@Service
public class CrearArticuloService implements CrearArticuloUseCase {
    private final ArticuloRepositoryPort repo;
    public CrearArticuloService(ArticuloRepositoryPort repo) {
        this.repo = repo;
    }
    @Override
    public Articulo crear(Articulo articulo) {
        return repo.save(articulo);
    }

}
