package com.belgem.backend.domain.port.in;

import com.belgem.backend.domain.model.Divisas;
import java.util.List;

public interface GestionarDivisasUseCase {
    List<Divisas> listar();
    Divisas guardar(Divisas divisas);
    Divisas actualizar(Long divisaId, Divisas data);
    void eliminar(Long divisaId);
    Divisas obtenerPorId(Long divisaId);
    void asegurarBasicas();
}