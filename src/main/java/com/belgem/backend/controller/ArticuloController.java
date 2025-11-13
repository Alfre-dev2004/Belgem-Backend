package com.belgem.backend.controller;

import com.belgem.backend.entity.Articulo;
import com.belgem.backend.service.ArticuloService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Marca esta clase como un "RestController" en Spring
// Permite recibir y responder solicitudes HTTP en formato JSON
@RestController
// Define la ruta base para todos los endpoints de este controlador
@RequestMapping("/articulos")
public class ArticuloController {

    // Inyecta el servicio de Articulo para acceder a la lógica de negocio
    private final ArticuloService articuloService;

    // Constructor que recibe el servicio (inyección de dependencias)
    public ArticuloController(ArticuloService articuloService) {
        this.articuloService = articuloService;
    }

    // Endpoint GET para listar todos los artículos
    @GetMapping
    public List<Articulo> listar() {
        // Llama al método listar() del servicio y devuelve la lista de artículos
        return articuloService.listar();
    }

    // Endpoint POST para crear un nuevo artículo
    @PostMapping
    public Articulo crear(@RequestBody Articulo articulo) {
        // @RequestBody indica que el artículo viene en el cuerpo de la petición en formato JSON
        // Llama al método guardar() del servicio para almacenar el artículo en la base de datos
        return articuloService.guardar(articulo);
    }

    // Endpoint DELETE para eliminar un artículo por su id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        // @PathVariable indica que el id se recibe desde la URL
        articuloService.eliminar(id);
        // Devuelve un 204 No Content para indicar que se eliminó correctamente
        return ResponseEntity.noContent().build();
    }

    // Endpoint PUT para actualizar un artículo existente
    @PutMapping("/{id}")
    public ResponseEntity<Articulo> actualizar(@PathVariable Long id, @RequestBody Articulo articulo) {
        try {
            // Llama al método actualizar() del servicio con el id y los nuevos datos
            Articulo actualizado = articuloService.actualizar(id, articulo);
            // Devuelve un 200 OK con el artículo actualizado
            return ResponseEntity.ok(actualizado);
        } catch (RuntimeException e) {
            // Si el artículo no se encuentra, devuelve un 404 Not Found
            return ResponseEntity.notFound().build();
        }
    }
}