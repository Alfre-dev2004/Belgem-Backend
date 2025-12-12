package com.belgem.backend.domain.port.input;
/**
 * Caso de uso para crear un almacén.
 *
 * La capa de aplicación debe implementar esta interfaz,
 * mientras que los controladores solo dependen del caso de uso.
 */

import com.belgem.backend.domain.model.Almacen;

public interface CrearAlmacenUseCase {
    Almacen crear(Almacen almacen);
}
