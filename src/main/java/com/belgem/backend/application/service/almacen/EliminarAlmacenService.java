package com.belgem.backend.application.service.almacen;
/**
 * Servicio encargado de eliminar un almacén por su identificador.
 *
 * Verifica primero si el almacén existe para evitar operaciones inválidas.
 * En caso contrario, lanza IllegalArgumentException.
 */

import com.belgem.backend.domain.port.input.EliminarAlmacenUseCase;
import com.belgem.backend.domain.port.output.AlmacenRepositoryPort;
import org.springframework.stereotype.Service;

@Service
public class EliminarAlmacenService implements EliminarAlmacenUseCase {

    private final AlmacenRepositoryPort repo;

    public EliminarAlmacenService(AlmacenRepositoryPort repo) {
        this.repo = repo;
    }

    @Override
    public void eliminar(Long id){
        // Comprobamos si existe antes de borrar
        if (repo.findById(id).isEmpty()) {
            throw new RuntimeException("Almacén with id " + id + " not found.");
        }

        // Si existe, lo borramos
        repo.deleteById(id);
    }
}
