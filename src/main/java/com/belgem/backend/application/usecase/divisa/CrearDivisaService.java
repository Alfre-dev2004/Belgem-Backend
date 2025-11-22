package com.belgem.backend.application.usecase.divisa;

import com.belgem.backend.domain.model.Divisa;
import com.belgem.backend.domain.port.input.CrearDivisaUseCase;
import com.belgem.backend.domain.port.output.DivisaRepositoryPort;
import org.springframework.stereotype.Service;

/**
 * Servicio que implementa el caso de uso para crear una nueva divisa.
    Usa repository como puerto de salida para las operaciones de persistencia de divisas.
 */
@Service
public class CrearDivisaService implements CrearDivisaUseCase {

    private final DivisaRepositoryPort repository; //usa el puerto de salida (repository)

    public CrearDivisaService(DivisaRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public Divisa crear(Divisa divisa){
        if(repository.existsByCode(divisa.getCode())){
            throw new RuntimeException("Divisa with code " + divisa.getCode() + " already exists."); //lanza error si la divisa ya existe.
        }
        return repository.save(divisa); //guarda la divisa si NO existe.
    }
}
