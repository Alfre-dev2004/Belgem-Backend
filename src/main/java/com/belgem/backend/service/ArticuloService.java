package com.belgem.backend.service;

import com.belgem.backend.entity.Articulo;
import com.belgem.backend.repository.ArticuloRepository;
import org.springframework.stereotype.Service;

import java.util.List;

// Marca esta clase como un "Service" en Spring
// Los Services contienen la lógica de negocio de la aplicación
@Service
public class ArticuloService {

    // Inyecta el repositorio de Articulo para acceder a la base de datos
    private final ArticuloRepository articuloRepository;

    // Constructor que recibe el repositorio (inyección de dependencias)
    public ArticuloService(ArticuloRepository articuloRepository) {
        this.articuloRepository = articuloRepository;
    }

    // Método para listar todos los artículos
    public List<Articulo> listar() {
        // Usa el método findAll() del repositorio
        return articuloRepository.findAll();
    }

    // Método para guardar un nuevo artículo
    public Articulo guardar(Articulo articulo) {
        // Usa el método save() del repositorio
        return articuloRepository.save(articulo);
    }

    // Método para eliminar un artículo por su id
    public void eliminar(Long id) {
        // Primero verifica si el artículo existe
        if (!articuloRepository.existsById(id)) {
            // Si no existe, lanza una excepción
            throw new IllegalArgumentException("Articulo no encontrado");
        }
        // Si existe, lo elimina usando deleteById()
        articuloRepository.deleteById(id);
    }

    // Método para actualizar un artículo existente
    public Articulo actualizar(Long id, Articulo articuloActualizado) {
        // Busca el artículo por su id
        return articuloRepository.findById(id).map(articulo -> {
            // Si lo encuentra, actualiza sus campos
            articulo.setNombre(articuloActualizado.getNombre());
            articulo.setPrecio(articuloActualizado.getPrecio());
            articulo.setDto(articuloActualizado.getDto());
            articulo.setCantidad(articuloActualizado.getCantidad());
            // Guarda el artículo actualizado y lo devuelve
            return articuloRepository.save(articulo);
            // Si no encuentra el artículo, lanza una excepción
        }).orElseThrow(() -> new RuntimeException("Artículo no encontrado con id: " + id));
    }

}
