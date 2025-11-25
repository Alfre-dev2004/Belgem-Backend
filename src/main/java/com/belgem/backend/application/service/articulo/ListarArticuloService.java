package com.belgem.backend.application.service.articulo;

import com.belgem.backend.domain.model.Articulo;
import com.belgem.backend.domain.port.input.ListarArticulosUseCase;
import com.belgem.backend.domain.port.output.ArticuloRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListarArticuloService implements ListarArticulosUseCase {
    private final ArticuloRepositoryPort repo;

    public ListarArticuloService(ArticuloRepositoryPort repo) {
        this.repo = repo;
    }

    @Override
    public List<Articulo> listar() {
        return repo.findAll();
    }
}
