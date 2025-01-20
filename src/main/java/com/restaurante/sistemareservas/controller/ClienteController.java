package com.restaurante.sistemareservas.controller;
import com.restaurante.sistemareservas.model.Cliente;
import com.restaurante.sistemareservas.service.ClienteService;
import org.hibernate.Remove;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public List<Cliente> listarTodos() {
        return clienteService.listarTodos();
    }
    @PostMapping
    public Cliente inserirCliente(@RequestBody Cliente cliente) {
        return clienteService.salvarCliente(cliente);
    }
    @DeleteMapping("/{id}")
    public void removerCliente(@PathVariable Long id) {
        clienteService.removerCliente(id);
    }
    @PutMapping("/{id}")
    public Cliente atualizarCliente(@PathVariable Long id, @RequestBody Cliente clienteAtualizado) {
        return clienteService.atualizarCliente(id, clienteAtualizado);
    }
}
