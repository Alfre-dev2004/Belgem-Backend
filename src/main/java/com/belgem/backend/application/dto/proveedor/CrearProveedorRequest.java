package com.belgem.backend.application.dto.proveedor;

public record CrearProveedorRequest(
        String nombre,
        String cif,
        String telefono,
        String email,
        String direccion,
        String ciudad,
        String pais
) {}

