package com.belgem.backend.application.service.articulo;

import com.belgem.backend.domain.exception.ArticuloNoEncontradoException;
import com.belgem.backend.domain.port.input.EliminarArticuloUseCase;
import com.belgem.backend.domain.port.output.ArticuloRepositoryPort;
import org.springframework.stereotype.Service;
/**
 * Servicio encargado de eliminar un artículo existente.
 * <p>
 * Este servicio implementa el caso de uso {@link EliminarArticuloUseCase} y se
 * comunica con el repositorio del dominio {@link ArticuloRepositoryPort} para
 * realizar la eliminación. Antes de eliminar, verifica que el artículo exista.
 * </p>
 *
 * Arquitectura Hexagonal:
 * - No conoce JPA.
 * - Solo trabaja con el puerto de salida.
 * - No maneja DTOs.
 */
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