package com.restaurante.sistemareservas.service;

import com.restaurante.sistemareservas.model.Reserva;
import com.restaurante.sistemareservas.model.Mesa;
import com.restaurante.sistemareservas.repository.ReservaRepository;
import com.restaurante.sistemareservas.repository.MesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReservaService {

    private final ReservaRepository reservaRepository;
    private final MesaRepository mesaRepository;

    @Autowired
    public ReservaService(ReservaRepository reservaRepository, MesaRepository mesaRepository) {
        this.reservaRepository = reservaRepository;
        this.mesaRepository = mesaRepository;
    }

    public List<Reserva> listarTodas() {
        return reservaRepository.findAll();
    }

    public Reserva salvarReserva(Reserva reserva) {
        if (!isMesaDisponivel(reserva.getMesa().getId(), reserva.getDataHora())) {
            throw new RuntimeException("A mesa não está disponível para o horário selecionado.");
        }

        // Atualizar a disponibilidade da mesa para false
        Mesa mesa = reserva.getMesa();
        mesa.setDisponivel(false);
        mesaRepository.save(mesa);

        return reservaRepository.save(reserva);
    }

    public Reserva atualizarReserva(Long id, Reserva reservaAtualizada) {
        return reservaRepository.findById(id)
                .map(reserva -> {
                    reserva.setMesa(reservaAtualizada.getMesa());
                    reserva.setCliente(reservaAtualizada.getCliente());
                    reserva.setDataHora(reservaAtualizada.getDataHora());
                    return reservaRepository.save(reserva);
                })
                .orElseThrow(() -> new RuntimeException("Reserva não encontrada com o ID: " + id));
    }

    public void removerReserva(Long id) {
        reservaRepository.deleteById(id);
    }

    public boolean isMesaDisponivel(Long mesaId, LocalDateTime dataHora) {
        List<Reserva> reservas = reservaRepository.findByMesaIdAndDataHora(mesaId, dataHora);
        return reservas.isEmpty();
    }
}
