package com.belgem.backend.application.service.divisa;

import com.belgem.backend.domain.port.output.DivisaRepositoryPort;
import com.belgem.backend.domain.port.input.EliminarDivisaUseCase;
import org.springframework.stereotype.Service;

@Service
public class EliminarDivisaService implements EliminarDivisaUseCase {

    private final DivisaRepositoryPort repository;

    public EliminarDivisaService(DivisaRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public void eliminarDivisa(Long id) {

        // Comprobamos si existe la divisa antes de borrar
        if (repository.findById(id).isEmpty()) {
            throw new RuntimeException("Divisa with id " + id + " not found.");
        }

        // Si existe, la borramos
        repository.deleteById(id);
    }
}
