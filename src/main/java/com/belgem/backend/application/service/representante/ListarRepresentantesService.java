package com.belgem.backend.application.service.representante;

import com.belgem.backend.domain.model.Representante;
import com.belgem.backend.domain.port.input.ListarRepresentantesUseCase;
import com.belgem.backend.domain.port.output.RepresentanteRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListarRepresentantesService implements ListarRepresentantesUseCase {

    private final RepresentanteRepositoryPort repository;

    public ListarRepresentantesService(RepresentanteRepositoryPort repository){
        this.repository = repository;
    }

    @Override
    public List<Representante> listar() {
        return repository.findAll();
    }
}
