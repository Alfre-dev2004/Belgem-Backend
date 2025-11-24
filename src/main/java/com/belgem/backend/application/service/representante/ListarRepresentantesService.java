package com.belgem.backend.application.service.representante;

import com.belgem.backend.domain.model.Representante;
import com.belgem.backend.domain.port.input.ListarRepresentantesUseCase;
import com.belgem.backend.domain.port.output.RepresentanteRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicio de aplicación encargado de manejar la operación de listar representantes.
 *
 * Forma parte de la capa de aplicación dentro de la arquitectura hexagonal
 * y simplemente delega la obtención de datos al puerto de repositorio.
 *
 * Usado por el controlador cuando se ejecuta el endpoint:
 * GET /representantes
 */
@Service
public class ListarRepresentantesService implements ListarRepresentantesUseCase {

    private final RepresentanteRepositoryPort repository;

    public ListarRepresentantesService(RepresentanteRepositoryPort repository){
        this.repository = repository;
    }

    /**
     * Devuelve la lista completa de representantes.
     *
     * Este método no contiene lógica adicional; únicamente
     * delega la consulta al repositorio correspondiente.
     */
    @Override
    public List<Representante> listar() {
        return repository.findAll();
    }
}
