package com.belgem.backend.application.usecase.divisa;
import com.belgem.backend.domain.model.Divisa;
import com.belgem.backend.domain.port.output.DivisaRepositoryPort;
import com.belgem.backend.domain.port.input.ListarDivisasUseCase;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ListarDivisasService implements  ListarDivisasUseCase {
    private final DivisaRepositoryPort repository;
    public ListarDivisasService(DivisaRepositoryPort repository) {
        this.repository = repository;
    }
@Override
    public List<Divisa> listar() {
        return repository.findAll();
    }
}
