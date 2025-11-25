package com.belgem.backend.application.service.articulo;

import com.belgem.backend.domain.model.Articulo;
import com.belgem.backend.domain.port.input.BuscarArticuloPorNombreUseCase;
import com.belgem.backend.domain.port.output.ArticuloRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * Servicio encargado de buscar artículos por nombre.
 * <p>
 * Este servicio implementa el caso de uso {@link BuscarArticuloPorNombreUseCase}
 * y ejecuta la búsqueda a través del puerto de salida {@link ArticuloRepositoryPort}.
 * La lógica específica de búsqueda (por ejemplo, ignore case o contains) queda
 * delegada a la capa de infraestructura.
 * </p>
 *
 * Arquitectura Hexagonal:
 * - No conoce detalles de la base de datos.
 * - No implementa queries, solo delega al puerto.
 * - Retorna entidades del dominio.
 */
@Service
public class ObtenerArticuloPorNombreService implements BuscarArticuloPorNombreUseCase {
    private final ArticuloRepositoryPort repo;

    public ObtenerArticuloPorNombreService(ArticuloRepositoryPort repo) {
        this.repo = repo;
    }

    @Override
    public List<Articulo> buscarPorNombre(String nombre) {
        return repo.findByNombre(nombre);
    }

}
