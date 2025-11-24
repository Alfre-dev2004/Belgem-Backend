package com.belgem.backend.domain.port.input;

import com.belgem.backend.domain.model.Representante;
import java.util.List;

public interface ListarRepresentantesUseCase {
    List<Representante> listar();
}
