package com.belgem.backend.application.service.articulo;

import com.belgem.backend.domain.model.Articulo;
import com.belgem.backend.domain.port.input.BuscarArticuloPorNombreUseCase;
import com.belgem.backend.domain.port.output.ArticuloRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ObtenerArticuloPorNombreService implements BuscarArticuloPorNombreUseCase {
    private final ArticuloRepositoryPort repo;

    public ObtenerArticuloPorNombreService(ArticuloRepositoryPort repo) {
        this.repo = repo;
    }

    @Override
    public List<Articulo> buscarPorNombre(String nombre) {
        return repo.findByNombreContainingIgnoreCase(nombre);
    }
}
