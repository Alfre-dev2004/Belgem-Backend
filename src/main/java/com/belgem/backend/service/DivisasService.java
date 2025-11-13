package com.belgem.backend.service;

import com.belgem.backend.entity.Divisas;
import com.belgem.backend.repository.DivisasRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DivisasService {

    private final DivisasRepository divisasRepository;

    public DivisasService(DivisasRepository divisasRepository) {
        this.divisasRepository = divisasRepository;
    }

    public List<Divisas> listar() {
        return divisasRepository.findAll();
    }

    public Divisas guardar(Divisas divisa) {
        // si quieres evitar duplicados por código:
        if (divisa.getCode() != null && divisasRepository.existsByCode(divisa.getCode())) {
            throw new RuntimeException("Ya existe una divisa con código " + divisa.getCode());
        }
        return divisasRepository.save(divisa);
    }

    public Divisas actualizar(Long id, Divisas data) {
        return divisasRepository.findById(id)
                .map(d -> {
                    d.setCode(data.getCode());
                    d.setName(data.getName());
                   /* d.setSimbolo(data.getSimbolo());*/
                    return divisasRepository.save(d);
                })
                .orElseThrow(() -> new RuntimeException("Divisa no encontrada con id " + id));
    }

    public void eliminar(Long id) {
        if (!divisasRepository.existsById(id)) {
            throw new RuntimeException("Divisa no encontrada con id " + id);
        }
        divisasRepository.deleteById(id);
    }

    public Divisas obtenerPorId(Long id) {
        return divisasRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Divisa no encontrada con id " + id));
    }
}
