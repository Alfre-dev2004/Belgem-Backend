package com.belgem.backend.application.service; // PAQUETE ACTUALIZADO

import com.belgem.backend.domain.model.Representante;
import com.belgem.backend.domain.port.in.GestionarRepresentanteUseCase; // IMPLEMENTA PORT DE ENTRADA
import com.belgem.backend.domain.port.out.RepresentanteRepositoryPort; // INYECTA PORT DE SALIDA
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepresentanteService implements GestionarRepresentanteUseCase {

    private final RepresentanteRepositoryPort repositoryPort;

    public RepresentanteService(RepresentanteRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    // Listar todos los representantes
    @Override
    public List<Representante> listar() {
        return repositoryPort.findAll();
    }

    // Guardar un representante nuevo
    @Override
    public Representante guardar(Representante rep) {
        if (rep.getEmail() != null && repositoryPort.existsByEmail(rep.getEmail())) {
            throw new RuntimeException("Ya existe un representante con email " + rep.getEmail());
        }
        return repositoryPort.save(rep);
    }

    // Actualizar un representante existente
    @Override
    public Representante actualizar(Long representanteId, Representante data) { // ID ACTUALIZADO
        return repositoryPort.findById(representanteId) // ID ACTUALIZADO
                .map(r -> {
                    r.setNombre(data.getNombre());
                    r.setTelefono(data.getTelefono());
                    r.setEmail(data.getEmail());
                    r.setZona(data.getZona());
                    r.setCodigoInterno(data.getCodigoInterno());
                    r.setComision(data.getComision());
                    return repositoryPort.save(r);
                })
                .orElseThrow(() -> new RuntimeException("Representante no encontrado con id " + representanteId)); // ID ACTUALIZADO
    }

    // Eliminar un representante por id
    @Override
    public void eliminar(Long representanteId) { // ID ACTUALIZADO
        if (!repositoryPort.existsById(representanteId)) { // ID ACTUALIZADO
            throw new RuntimeException("Representante no encontrado con id " + representanteId); // ID ACTUALIZADO
        }
        repositoryPort.deleteById(representanteId); // ID ACTUALIZADO
    }

    // Obtener un representante por id
    @Override
    public Representante obtenerPorId(Long representanteId) { // ID ACTUALIZADO
        return repositoryPort.findById(representanteId) // ID ACTUALIZADO
                .orElseThrow(() -> new RuntimeException("Representante no encontrado con id " + representanteId)); // ID ACTUALIZADO
    }
}