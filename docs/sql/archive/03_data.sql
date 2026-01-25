INSERT INTO belgem.representantes
(nombre, telefono, email, zona, codigointerno, comision)
VALUES
    ('Juan Pérez', '600000001', 'juan@example.com', 'Norte', 'REP-001', 6.00),
    ('Ana López', '600000002', 'ana@example.com', 'Sur', 'REP-002', 7.50)
    ON CONFLICT (codigointerno) DO NOTHING;
