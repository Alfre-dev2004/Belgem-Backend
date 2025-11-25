package com.belgem.backend.application.service.articulo;

import com.belgem.backend.domain.model.Articulo;
import com.belgem.backend.domain.port.input.CrearArticuloUseCase;
import com.belgem.backend.domain.port.output.ArticuloRepositoryPort;
import org.springframework.stereotype.Service;

/**
 * Servicio encargado de crear un nuevo artículo en el sistema.
 * <p>
 * Implementa el caso de uso {@link CrearArticuloUseCase} y utiliza
 * el puerto de salida {@link ArticuloRepositoryPort} para interactuar con
 * la capa de persistencia. Antes de crear un artículo, valida que no exista
 * otro artículo con el mismo nombre, para evitar duplicados en el negocio.
 * </p>
 *
 * Principios de Arquitectura Hexagonal:
 *
 *     -No conoce JPA
 *     -Solo usa el puerto del dominio
 *     -Devuelve entidades del dominio
 *     -No maneja DTOs
 *
 */
@Service
public class CrearArticuloService implements CrearArticuloUseCase {
    private final ArticuloRepositoryPort repo;
    public CrearArticuloService(ArticuloRepositoryPort repo) {
        this.repo = repo;
    }
    @Override
    public Articulo crear(Articulo articulo) {
        if (repo.existsByNombre(articulo.getNombre())) { //validadion para que no se repita por nombre
            throw new IllegalArgumentException("Ya existe un artículo con ese nombre");
        }
        return repo.save(articulo);
    }

}
