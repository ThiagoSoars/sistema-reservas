package com.restaurante.sistemareservas.service;

import com.restaurante.sistemareservas.model.Mesa;
import com.restaurante.sistemareservas.repository.MesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MesaService {

    private final MesaRepository mesaRepository;

    @Autowired
    public MesaService(MesaRepository mesaRepository) {
        this.mesaRepository = mesaRepository;
    }

    public List<Mesa> listarTodas() {
        return mesaRepository.findAll();
    }

    public Mesa salvarMesa(Mesa mesa) {
        return mesaRepository.save(mesa);
    }

    public Mesa atualizarMesa(Long id, Mesa mesaAtualizada) {
        return mesaRepository.findById(id)
                .map(mesa -> {
                    mesa.setNumero(mesaAtualizada.getNumero());
                    mesa.setDisponivel(mesaAtualizada.isDisponivel());
                    return mesaRepository.save(mesa);
                })
                .orElseThrow(() -> new RuntimeException("Mesa não encontrada com o ID: " + id));
    }

    public void removerMesa(Long id) {
        mesaRepository.deleteById(id);
    }
}
