-- ====================================================================
-- 03_data.sql
-- Datos iniciales semilla del proyecto Belgem
-- ====================================================================

-- ==========================
-- DIVISAS
-- ==========================
INSERT INTO belgem.divisas (code, name) VALUES
                                            ('EUR', 'Euro'),
                                            ('USD', 'US Dollar')
    ON CONFLICT (code) DO NOTHING;

-- ==========================
-- REPRESENTANTES
-- ==========================
INSERT INTO belgem.representantes (nombre, telefono, email, zona, codigointerno, comision) VALUES
                                                                                               ('Juan Pérez', '600000001', 'juan@example.com', 'Norte', 'REP-001', 6.00),
                                                                                               ('Ana López', '600000002', 'ana@example.com', 'Sur', 'REP-002', 7.50)
    ON CONFLICT (codigointerno) DO NOTHING;

-- ==========================
-- CLIENTES
-- ==========================
INSERT INTO belgem.cliente (nombre, nif, telefono, email, zona, tipoCliente, ciudad) VALUES
                                                                                         ('Cliente Prueba 1', '12345678A', '600111111', 'c1@example.com', 'Zona Norte', 'Mayorista', 'Madrid'),
                                                                                         ('Cliente Prueba 2', '87654321B', '600222222', 'c2@example.com', 'Zona Sur', 'Minorista', 'Barcelona')
    ON CONFLICT (nif) DO NOTHING;

-- ==========================
-- ARTICULOS
-- ==========================
INSERT INTO belgem.articulos (nombre, cantidad, dto, precio) VALUES
                                                                 ('Tornillo M6', 100, 0, 0.25),
                                                                 ('Tuerca M8', 200, 5, 0.40);

-- ==========================
-- ALMACENES
-- ==========================
INSERT INTO belgem.almacenes (nombre, direccion, telefono, responsable, activo) VALUES
                                                                                    ('Almacén Central', 'C/ Inventada 123', '600333444', 'María López', TRUE),
                                                                                    ('Almacén Secundario', 'Av. Del Ejemplo 45', '600555666', 'Pedro Gómez', TRUE);
