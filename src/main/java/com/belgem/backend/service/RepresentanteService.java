package com.belgem.backend.service;

import com.belgem.backend.entity.Representante;
import com.belgem.backend.repository.RepresentanteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepresentanteService {

    private final RepresentanteRepository repository;

    public RepresentanteService(RepresentanteRepository repository) {
        this.repository = repository;
    }

    // Listar todos los representantes
    public List<Representante> listar() {
        return repository.findAll();
    }

    // Guardar un representante nuevo
    public Representante guardar(Representante rep) {
        if (rep.getEmail() != null && repository.existsByEmail(rep.getEmail())) {
            throw new RuntimeException("Ya existe un representante con email " + rep.getEmail());
        }
        return repository.save(rep);
    }

    // Actualizar un representante existente
    public Representante actualizar(Long id, Representante data) {
        return repository.findById(id)
                .map(r -> {
                    r.setNombre(data.getNombre());
                    r.setTelefono(data.getTelefono());
                    r.setEmail(data.getEmail());
                    r.setZona(data.getZona());
                    r.setCodigoInterno(data.getCodigoInterno());
                    r.setComision(data.getComision());
                    return repository.save(r);
                })
                .orElseThrow(() -> new RuntimeException("Representante no encontrado con id " + id));
    }

    // Eliminar un representante por id
    public void eliminar(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Representante no encontrado con id " + id);
        }
        repository.deleteById(id);
    }

    // Obtener un representante por id
    public Representante obtenerPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Representante no encontrado con id " + id));
    }
}
