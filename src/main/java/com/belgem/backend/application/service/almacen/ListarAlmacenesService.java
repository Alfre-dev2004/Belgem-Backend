package com.belgem.backend.application.service.almacen;
/**
 * Entidad JPA que representa la tabla belgem.almacenes.
 *
 * Esta clase pertenece estrictamente a la infraestructura.
 * No forma parte del dominio y debe ser convertida mediante un mapper
 * antes de ser usada en lógica de negocio.
 */

import com.belgem.backend.domain.model.Almacen;
import com.belgem.backend.domain.port.input.ListarAlmacenUseCase;
import com.belgem.backend.domain.port.output.AlmacenRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListarAlmacenesService implements ListarAlmacenUseCase {
    private final AlmacenRepositoryPort repo;

    public ListarAlmacenesService(AlmacenRepositoryPort repo) {
        this.repo = repo;
    }

    @Override
    public List<Almacen> listar(){
        return repo.findAll();
    }
}
