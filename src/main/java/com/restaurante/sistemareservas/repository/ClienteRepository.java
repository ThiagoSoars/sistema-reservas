package com.restaurante.sistemareservas.repository;

import com.restaurante.sistemareservas.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    // Não é necessário adicionar métodos aqui para operações básicas
}
