package com.belgem.backend.application.service.almacen;
/**
 * Servicio de aplicación encargado de actualizar un almacén existente.
 *
 * Flujo:
 *  1. Verificar existencia por ID.
 *  2. Crear una nueva instancia del modelo de dominio con los valores actualizados.
 *  3. Delegar el guardado al repositorio.
 *
 * Lanza IllegalArgumentException si el almacén no existe.
 */

import com.belgem.backend.domain.model.Almacen;
import com.belgem.backend.domain.port.input.ActualizarAlmacenUseCase;
import com.belgem.backend.domain.port.output.AlmacenRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ActualizarAlmacenService implements ActualizarAlmacenUseCase {

    private final AlmacenRepositoryPort repo;

    public ActualizarAlmacenService(AlmacenRepositoryPort repo) {
        this.repo = repo;
    }

    @Override
    public Almacen actualizar(Long id, Almacen nuevosDatos) {

        Almacen existente = repo.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Warehouse with id " + id + " not found.")
                );

        Almacen actualizado = new Almacen(
                id,
                nuevosDatos.getNombre(),
                nuevosDatos.getDireccion(),
                nuevosDatos.getTelefono(),
                nuevosDatos.getResponsable(),
                nuevosDatos.isActivo()
        );

        return repo.save(actualizado);
    }
}
