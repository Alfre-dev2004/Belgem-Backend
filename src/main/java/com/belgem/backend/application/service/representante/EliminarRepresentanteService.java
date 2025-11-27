package com.belgem.backend.application.service.representante;

import com.belgem.backend.domain.port.input.EliminarRepresentanteUseCase;
import com.belgem.backend.domain.port.output.RepresentanteRepositoryPort;
import org.springframework.stereotype.Service;

@Service
public class EliminarRepresentanteService implements EliminarRepresentanteUseCase {

    private final RepresentanteRepositoryPort repository;

    public EliminarRepresentanteService(RepresentanteRepositoryPort repository){
        this.repository = repository;
    }

    @Override
    public void eliminar(Long id) {
        // Validación: el representante debe existir
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("El representante con ID " + id + " no existe.");
        }

        // Eliminación
        repository.deleteById(id);
    }
}
