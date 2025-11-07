package com.belgem.backend.controller;

import com.belgem.backend.entity.Cliente;
import com.belgem.backend.service.ClienteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public List<Cliente> getClientes() {
        return clienteService.listarTodos();
    }
}
