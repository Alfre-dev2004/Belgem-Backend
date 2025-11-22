package com.belgem.backend.application.usecase.divisa;

import com.belgem.backend.domain.model.Divisa;
import com.belgem.backend.domain.port.input.ObtenerDivisaPorIdUseCase;
import com.belgem.backend.domain.port.output.DivisaRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Implementación del caso de uso para obtener una divisa por su ID.
 * Forma parte de la capa Application: orquesta el flujo del caso de uso
 * usando el puerto de salida DivisaRepositoryPort.
 */
@Service
public class ObtenerDivisaPorIdService implements ObtenerDivisaPorIdUseCase {

    private final DivisaRepositoryPort repository;

    public ObtenerDivisaPorIdService(DivisaRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public Divisa obtener(Long id) {
        Optional<Divisa> divisaOpt = repository.findById(id);

        if (divisaOpt.isEmpty()) {
            throw new RuntimeException("Divisa with id " + id + " not found.");
        }

        return divisaOpt.get();
    }
}
