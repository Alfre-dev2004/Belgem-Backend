package com.belgem.backend.application.service.divisa;

import com.belgem.backend.domain.model.Divisa;
import com.belgem.backend.domain.port.output.DivisaRepositoryPort;
import com.belgem.backend.domain.port.input.ActualizarDivisaUseCase;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ActualizarDivisaService implements ActualizarDivisaUseCase {

    private final DivisaRepositoryPort repository;

    public ActualizarDivisaService(DivisaRepositoryPort repository){
        this.repository = repository;
    }

    @Override
    public Divisa actualizar(Long id, Divisa datos) {

        // 1. Buscar la divisa actual
        Optional<Divisa> existenteOpt = repository.findById(id);

        if (existenteOpt.isEmpty()) {
            throw new RuntimeException("Divisa with id " + id + " not found.");
        }

        Divisa existente = existenteOpt.get();

        // 2. Crear una nueva Divisa con el mismo id pero con los nuevos datos
        Divisa actualizada = new Divisa(
                existente.getId(),     // mantenemos el mismo id
                datos.getCode(),       // nuevo código
                datos.getName()        // nuevo nombre
        );

        // 3. Guardar usando el puerto de salida
        return repository.save(actualizada);
    }
}
