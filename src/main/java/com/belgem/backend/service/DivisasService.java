package com.belgem.backend.service;

import com.belgem.backend.entity.Divisas;
import com.belgem.backend.repository.DivisasRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DivisasService {

    private final DivisasRepository divisasRepository;

    public DivisasService(DivisasRepository divisasRepository) {
        this.divisasRepository = divisasRepository;
    }

    public List<Divisas> listar() {
        // nos aseguramos de que existan las 3
        asegurarBasicas();
        return divisasRepository.findAll();
    }

    public Divisas guardar(Divisas divisas) {
        // evitar duplicados por código:
        if (divisas.getCode() != null && divisasRepository.existsByCode(divisas.getCode())) {
            throw new RuntimeException("Ya existe una divisa con código " + divisas.getCode());
        }
        return divisasRepository.save(divisas);
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
    // se ejecuta justo al arrancar la app
    @PostConstruct
    private void asegurarBasicas() {
        // EUR
        if (!divisasRepository.existsByCode("EUR")) {
            divisasRepository.save(new Divisas("EUR", "EURO"));
        }
        // USD
        if (!divisasRepository.existsByCode("USD")) {
            divisasRepository.save(new Divisas("USD", "DÓLAR USA"));
        }
        // dólar propio
        if (!divisasRepository.existsByCode("USX")) {
            divisasRepository.save(new Divisas("USX", "DÓLAR BELGEM +10%"));
        }

    }
}
