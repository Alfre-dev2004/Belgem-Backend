package com.belgem.backend.repository;

import com.belgem.backend.entity.Articulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Indica que esta interfaz es un "Repository" de Spring
// Los repositorios son responsables de la persistencia de datos (leer/escribir en la base de datos)
@Repository
// Definimos la interfaz ArticuloRepository que extiende JpaRepository
// JpaRepository ya incluye métodos listos para CRUD (Create, Read, Update, Delete)
// <Articulo, Long> indica que esta repo maneja entidades Articulo y la clave primaria es de tipo Long

public interface ArticuloRepository extends JpaRepository<Articulo, Long> {
}
