package com.restaurante.sistemareservas.model;

import com.restaurante.sistemareservas.model.Cliente;
import com.restaurante.sistemareservas.model.Mesa;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Table(name = "reserva")
@Entity
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne  // Indica um relacionamento muitos-para-um com a entidade Cliente
    private Cliente cliente;

    @ManyToOne  // Indica um relacionamento muitos-para-um com a entidade Mesa
    private Mesa mesa;

    private LocalDateTime dataHora;

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }
}
