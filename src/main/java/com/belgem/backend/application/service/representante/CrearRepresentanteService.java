package com.belgem.backend.application.service.representante;

import com.belgem.backend.domain.model.Representante;
import com.belgem.backend.domain.port.input.CrearRepresentanteUseCase;
import com.belgem.backend.domain.port.output.RepresentanteRepositoryPort;
import org.springframework.stereotype.Service;

@Service
public class CrearRepresentanteService implements CrearRepresentanteUseCase {

    private final RepresentanteRepositoryPort repository;

    public CrearRepresentanteService(RepresentanteRepositoryPort repository){
        this.repository = repository;
    }

    @Override
    public Representante crear(Representante representante) {
        return repository.save(representante);
    }
}
