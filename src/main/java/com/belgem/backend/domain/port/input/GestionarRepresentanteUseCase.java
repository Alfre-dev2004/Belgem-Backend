package com.belgem.backend.domain.port.input;

import com.belgem.backend.domain.model.Representante;
import java.util.List;

public interface GestionarRepresentanteUseCase {
    List<Representante> listar();
    Representante guardar(Representante rep);
    Representante actualizar(Long representanteId, Representante data);
    void eliminar(Long representanteId);
    Representante obtenerPorId(Long representanteId);
}