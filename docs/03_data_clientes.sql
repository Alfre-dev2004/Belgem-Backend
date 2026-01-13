-- Datos iniciales para el módulo Clientes

INSERT INTO belgem.cliente (nombre, nif, telefono, email, zona, tipoCliente)
VALUES
    ('Cliente Prueba 1', '12345678A', '600111111', 'c1@example.com', 'Zona Norte', 'Mayorista'),
    ('Cliente Prueba 2', '87654321B', '600222222', 'c2@example.com', 'Zona Sur', 'Minorista')
    ON CONFLICT (nif) DO NOTHING;
