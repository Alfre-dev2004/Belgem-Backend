package com.belgem.backend.application.service.articulo;

import com.belgem.backend.domain.model.Articulo;
import com.belgem.backend.domain.port.input.ListarArticulosUseCase;
import com.belgem.backend.domain.port.output.ArticuloRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * Servicio encargado de listar todos los artículos disponibles.
 * <p>
 * Implementa el caso de uso {@link ListarArticulosUseCase} y obtiene
 * la lista de artículos desde el puerto de salida {@link ArticuloRepositoryPort}.
 * </p>
 *
 * Arquitectura Hexagonal:
 * - No contiene lógica de negocio.
 * - No interactúa con JPA directamente.
 * - Devuelve entidades del dominio.
 */
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
