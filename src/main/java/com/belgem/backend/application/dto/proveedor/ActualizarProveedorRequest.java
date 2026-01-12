package com.belgem.backend.application.dto.proveedor;

public record ActualizarProveedorRequest(
        String nombre,
        String cif,
        String telefono,
        String email,
        String direccion,
        String ciudad,
        String pais,
        Boolean activo
) {}
