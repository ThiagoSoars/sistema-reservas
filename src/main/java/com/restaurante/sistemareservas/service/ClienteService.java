package com.restaurante.sistemareservas.service;
import com.restaurante.sistemareservas.model.Cliente;
import com.restaurante.sistemareservas.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }


    //listando todos os clientes
    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }
    //Salvando os clientes
    public Cliente salvarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }
    public void removerCliente(Long id) {
        clienteRepository.deleteById(id);
    }

        public Cliente atualizarCliente(Long id, Cliente clienteAtualizado) {
            return clienteRepository.findById(id)
                    .map(cliente -> {
                        cliente.setNome(clienteAtualizado.getNome());
                        cliente.setEmail(clienteAtualizado.getEmail());
                        cliente.setTelefone(clienteAtualizado.getTelefone());
                        return clienteRepository.save(cliente);
                    })
                    .orElseThrow(() -> new RuntimeException("Cliente não encontrado com o ID: " + id));
        }
    }


