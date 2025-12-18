package com.belgem.backend.application.service.almacen;
/**
 * Servicio de aplicación encargado de gestionar el caso de uso de creación de almacenes.
 *
 * - No conoce JPA ni controladores.
 * - Solo coordina reglas de negocio y delega en el repositorio (puerto de salida).
 * - Aplica validaciones si el dominio lo requiere.
 */

import com.belgem.backend.domain.model.Almacen;
import com.belgem.backend.domain.port.input.CrearAlmacenUseCase;
import com.belgem.backend.domain.port.output.AlmacenRepositoryPort;
import org.springframework.stereotype.Service;

@Service
public class CrearAlmacenService implements CrearAlmacenUseCase {
    private final AlmacenRepositoryPort repo;

    public CrearAlmacenService(AlmacenRepositoryPort repo) {
        this.repo = repo;
    }

    @Override
    public Almacen crear(Almacen almacen) {
        return repo.save(almacen);
    }
}
