-- Constraints del módulo Clientes
ALTER TABLE belgem.cliente
    ADD CONSTRAINT fk_cliente_representante
        FOREIGN KEY (representante_id)
            REFERENCES belgem.representantes(id);
