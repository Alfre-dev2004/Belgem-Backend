-- 03_data.sql
-- Datos iniciales (idempotente)

-- Representantes
INSERT INTO belgem.representantes
(nombre, telefono, email, zona, codigointerno, comision)
VALUES
    ('Juan Pérez', '600000001', 'juan@example.com', 'Norte', 'REP-001', 6.00),
    ('Ana López', '600000002', 'ana@example.com', 'Sur', 'REP-002', 7.50)
    ON CONFLICT (codigointerno) DO NOTHING;

-- Clientes
INSERT INTO belgem.cliente (nombre, nif, telefono, email, zona, tipoCliente)
VALUES
    ('Cliente Prueba 1', '12345678A', '600111111', 'c1@example.com', 'Zona Norte', 'Mayorista'),
    ('Cliente Prueba 2', '87654321B', '600222222', 'c2@example.com', 'Zona Sur', 'Minorista')
    ON CONFLICT (nif) DO NOTHING;

-- Divisas
INSERT INTO belgem.divisas (code, name) VALUES
                                            ('EUR', 'Euro'),
                                            ('USD', 'US Dollar')
    ON CONFLICT (code) DO NOTHING;
