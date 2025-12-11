package com.belgem.backend.infrastructure.adapter.input.web;
/**
 * Controlador REST del módulo Almacén.
 *
 * Expone los endpoints HTTP y delega las operaciones en los casos de uso.
 * No contiene lógica de negocio ni lógica de persistencia.
 *
 * Endpoints:
 *  - GET    /api/v1/almacenes
 *  - POST   /api/v1/almacenes
 *  - PUT    /api/v1/almacenes/{id}
 *  - DELETE /api/v1/almacenes/{id}
 */


import com.belgem.backend.domain.model.Almacen;
import com.belgem.backend.domain.port.input.ActualizarAlmacenUseCase;
import com.belgem.backend.domain.port.input.CrearAlmacenUseCase;
import com.belgem.backend.domain.port.input.EliminarAlmacenUseCase;
import com.belgem.backend.domain.port.input.ListarAlmacenUseCase;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/almacenes")

public class AlmacenController {

    private final CrearAlmacenUseCase crearAlmacen;
    private final ListarAlmacenUseCase listarAlmacen;
    private final ActualizarAlmacenUseCase actualizarAlmacen;
    private final EliminarAlmacenUseCase eliminarAlmacen;


    public AlmacenController(
            CrearAlmacenUseCase crearAlmacen,
            ListarAlmacenUseCase listarAlmacen,
            ActualizarAlmacenUseCase actualizarAlmacen,
            EliminarAlmacenUseCase eliminarAlmacen
    ) {
        this.crearAlmacen = crearAlmacen;
        this.listarAlmacen = listarAlmacen;
        this.actualizarAlmacen = actualizarAlmacen;
        this.eliminarAlmacen = eliminarAlmacen;
    }

    /**
     * Devuelve la lista completa de almacenes registrados.
     */

    @GetMapping
    public List<Almacen> listar() {
        return listarAlmacen.listar();
    }

    /**
     * Crea un nuevo almacén a partir del cuerpo recibido.
     */
    @PostMapping
    public Almacen crear(@RequestBody Almacen request) {
        return crearAlmacen.crear(request);
    }

    /**
     * Actualiza un almacén existente con datos nuevos.
     */
    @PutMapping("/{id}")
    public Almacen actualizar(@PathVariable Long id, @RequestBody Almacen request)
    {
        return actualizarAlmacen.actualizar(id, request);
    }

    /**
     * Elimina un almacén por ID si existe.
     */
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        eliminarAlmacen.eliminar(id);
    }
}
