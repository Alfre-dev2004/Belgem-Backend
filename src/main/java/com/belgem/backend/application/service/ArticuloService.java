package com.belgem.backend.application.service; // PAQUETE ACTUALIZADO

import com.belgem.backend.domain.model.Articulo;
import com.belgem.backend.domain.port.in.GestionarArticuloUseCase; // IMPLEMENTA PORT DE ENTRADA
import com.belgem.backend.domain.port.out.ArticuloRepositoryPort; // INYECTA PORT DE SALIDA
import org.springframework.stereotype.Service;

import java.util.List;

// Marca esta clase como un "Service" en Spring
// Los Services contienen la lógica de negocio de la aplicación
@Service
public class ArticuloService implements GestionarArticuloUseCase {

    // Inyecta el repositorio de Articulo para acceder a la base de datos
    private final ArticuloRepositoryPort repositoryPort;

    // Constructor que recibe el repositorio (inyección de dependencias)
    public ArticuloService(ArticuloRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    // Método para listar todos los artículos
    @Override
    public List<Articulo> listar() {
        // Usa el método findAll() del repositorio
        return repositoryPort.findAll();
    }

    // Método para guardar un nuevo artículo
    @Override
    public Articulo guardar(Articulo articulo) {
        // Usa el método save() del repositorio
        return repositoryPort.save(articulo);
    }

    // Método para eliminar un artículo por su id
    @Override
    public void eliminar(Long articuloId) { // ID ACTUALIZADO
        // Primero verifica si el artículo existe
        if (!repositoryPort.existsById(articuloId)) {
            // Si no existe, lanza una excepción
            throw new IllegalArgumentException("Articulo no encontrado");
        }
        // Si existe, lo elimina usando deleteById()
        repositoryPort.deleteById(articuloId);
    }

    // Método para actualizar un artículo existente
    @Override
    public Articulo actualizar(Long articuloId, Articulo articuloActualizado) { // ID ACTUALIZADO
        // Busca el artículo por su id
        return repositoryPort.findById(articuloId).map(articulo -> { // ID ACTUALIZADO
            // Si lo encuentra, actualiza sus campos
            articulo.setNombre(articuloActualizado.getNombre());
            articulo.setPrecio(articuloActualizado.getPrecio());
            articulo.setDto(articuloActualizado.getDto());
            articulo.setCantidad(articuloActualizado.getCantidad());
            // Guarda el artículo actualizado y lo devuelve
            return repositoryPort.save(articulo);
            // Si no encuentra el artículo, lanza una excepción
        }).orElseThrow(() -> new RuntimeException("Artículo no encontrado con id: " + articuloId)); // ID ACTUALIZADO
    }

}