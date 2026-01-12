package com.belgem.backend.application.service.proveedor;

import com.belgem.backend.domain.exception.ProveedorNoEncontradoException;
import com.belgem.backend.domain.model.Proveedor;
import com.belgem.backend.domain.port.input.ActualizarProveedorUseCase;
import com.belgem.backend.domain.port.output.ProveedorRepositoryPort;
import org.springframework.stereotype.Service;

@Service
public class ActualizarProveedorService implements ActualizarProveedorUseCase {

    private final ProveedorRepositoryPort repo;

    public ActualizarProveedorService(ProveedorRepositoryPort repo) {
        this.repo = repo;
    }

    @Override
    public Proveedor actualizar(Long id, Proveedor datos) {

        Proveedor existente = repo.findById(id)
                .orElseThrow(() -> new ProveedorNoEncontradoException(id));

        // Validar nombre duplicado
        if (!existente.getNombre().equals(datos.getNombre()) &&
                repo.existsByNombre(datos.getNombre())) {
            throw new IllegalArgumentException("Ya existe un proveedor con ese nombre");
        }

        Proveedor actualizado = new Proveedor(
                id,
                datos.getNombre(),
                datos.getCif(),
                datos.getTelefono(),
                datos.getEmail(),
                datos.getDireccion(),
                datos.getCiudad(),
                datos.getPais(),
                datos.getActivo()
        );

        return repo.save(actualizado);
    }
}
