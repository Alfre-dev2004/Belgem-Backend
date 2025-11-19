package com.belgem.backend.application.service; // PAQUETE ACTUALIZADO

import com.belgem.backend.domain.model.Divisas;
import com.belgem.backend.domain.port.input.GestionarDivisasUseCase; // IMPLEMENTA PORT DE ENTRADA
import com.belgem.backend.domain.port.output.DivisasRepositoryPort; // INYECTA PORT DE SALIDA
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DivisasService implements GestionarDivisasUseCase {

    private final DivisasRepositoryPort repositoryPort;

    public DivisasService(DivisasRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    @Override
    public List<Divisas> listar() {
        // nos aseguramos de que existan las 3
        asegurarBasicas();
        return repositoryPort.findAll();
    }

    @Override
    public Divisas guardar(Divisas divisas) {
        // evitar duplicados por código:
        if (divisas.getCode() != null && repositoryPort.existsByCode(divisas.getCode())) {
            throw new RuntimeException("Ya existe una divisa con código " + divisas.getCode());
        }
        return repositoryPort.save(divisas);
    }

    @Override
    public Divisas actualizar(Long divisaId, Divisas data) { // ID ACTUALIZADO
        return repositoryPort.findById(divisaId) // ID ACTUALIZADO
                .map(d -> {
                    d.setCode(data.getCode());
                    d.setName(data.getName());
                    /* d.setSimbolo(data.getSimbolo());*/
                    return repositoryPort.save(d);
                })
                .orElseThrow(() -> new RuntimeException("Divisa no encontrada con id " + divisaId)); // ID ACTUALIZADO
    }

    @Override
    public void eliminar(Long divisaId) { // ID ACTUALIZADO
        if (!repositoryPort.existsById(divisaId)) { // ID ACTUALIZADO
            throw new RuntimeException("Divisa no encontrada con id " + divisaId); // ID ACTUALIZADO
        }
        repositoryPort.deleteById(divisaId); // ID ACTUALIZADO
    }

    @Override
    public Divisas obtenerPorId(Long divisaId) { // ID ACTUALIZADO
        return repositoryPort.findById(divisaId) // ID ACTUALIZADO
                .orElseThrow(() -> new RuntimeException("Divisa no encontrada con id " + divisaId)); // ID ACTUALIZADO
    }
    // se ejecuta justo al arrancar la app
    @PostConstruct
    @Override
    public void asegurarBasicas() {
        // EUR
        if (!repositoryPort.existsByCode("EUR")) {
            repositoryPort.save(new Divisas("EUR", "EURO"));
        }
        // USD
        if (!repositoryPort.existsByCode("USD")) {
            repositoryPort.save(new Divisas("USD", "DÓLAR USA"));
        }
        // dólar propio
        if (!repositoryPort.existsByCode("USX")) {
            repositoryPort.save(new Divisas("USX", "DÓLAR BELGEM +10%"));
        }

    }
}