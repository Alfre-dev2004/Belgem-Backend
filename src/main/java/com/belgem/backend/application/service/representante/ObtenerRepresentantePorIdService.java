package com.belgem.backend.application.service.representante;

import com.belgem.backend.domain.model.Representante;
import com.belgem.backend.domain.port.input.ObtenerRepresentantePorIdUseCase;
import com.belgem.backend.domain.port.output.RepresentanteRepositoryPort;
import org.springframework.stereotype.Service;

@Service
public class ObtenerRepresentantePorIdService implements ObtenerRepresentantePorIdUseCase {

    private final RepresentanteRepositoryPort repository;

    public ObtenerRepresentantePorIdService(RepresentanteRepositoryPort repository){
        this.repository = repository;
    }

    @Override
    public Representante obtenerRepresentantePorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("El representante con ID " + id + " no existe."));
    }
}
