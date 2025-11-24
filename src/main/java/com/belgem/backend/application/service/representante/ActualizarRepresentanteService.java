package com.belgem.backend.application.service.representante;

import com.belgem.backend.domain.model.Representante;
import com.belgem.backend.domain.port.input.ActualizarRepresentanteUseCase;
import com.belgem.backend.domain.port.output.RepresentanteRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ActualizarRepresentanteService implements ActualizarRepresentanteUseCase {

    private final RepresentanteRepositoryPort repository;

    public ActualizarRepresentanteService(RepresentanteRepositoryPort repository){
        this.repository = repository;
    }

    @Override
    public Representante actualizar(Long id, Representante datos) {

        Optional<Representante> existenteOpt = repository.findById(id);

        if (existenteOpt.isEmpty()) {
            throw new RuntimeException("El representante con ID " + id + " no existe.");
        }

        Representante existente = existenteOpt.get();

        Representante actualizado = new Representante(
                existente.getId(),
                datos.getName(),
                datos.getPhone(),
                datos.getEmail(),
                datos.getZone(),
                datos.getInternalCode(),
                datos.getCommission()
        );

        return repository.save(actualizado);
    }
}
