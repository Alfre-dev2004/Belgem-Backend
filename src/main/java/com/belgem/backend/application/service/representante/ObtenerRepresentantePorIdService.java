package com.belgem.backend.application.service.representante;

import com.belgem.backend.domain.model.Representante;
import com.belgem.backend.domain.port.input.ObtenerRepresentantePorIdUseCase;
import com.belgem.backend.domain.port.output.RepresentanteRepositoryPort;
import org.springframework.stereotype.Service;
/**
 * Caso de uso encargado de obtener un representante por su ID.
 *
 * Forma parte de la capa de aplicación dentro de la arquitectura hexagonal.
 * Este servicio no contiene lógica de negocio: simplemente coordina la operación
 * delegando la consulta al repositorio del dominio.
 *
 * Es utilizado por el controlador cuando se llama al endpoint:
 * GET /representantes/{id}
 */
@Service
public class ObtenerRepresentantePorIdService implements ObtenerRepresentantePorIdUseCase {

    private final RepresentanteRepositoryPort repository;

    public ObtenerRepresentantePorIdService(RepresentanteRepositoryPort repository){
        this.repository = repository;
    }

    /**
     * Obtiene un representante por su ID.
     *
     * Si no existe, lanza IllegalArgumentException para mantener
     * la consistencia con el resto de módulos (Clientes, Divisas).
     */
    @Override
    public Representante obtener(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("El representante con ID " + id + " no existe."));
    }
}
