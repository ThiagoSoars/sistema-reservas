package com.restaurante.sistemareservas.controller;

import com.restaurante.sistemareservas.model.Mesa;
import com.restaurante.sistemareservas.service.MesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mesas")
public class MesaController {

    private final MesaService mesaService;

    @Autowired
    public MesaController(MesaService mesaService) {
        this.mesaService = mesaService;
    }

    @GetMapping
    public List<Mesa> listarTodas() {
        return mesaService.listarTodas();
    }

    @PostMapping
    public Mesa adicionarMesa(@RequestBody Mesa mesa) {
        return mesaService.salvarMesa(mesa);
    }

    @PutMapping("/{id}")
    public Mesa atualizarMesa(@PathVariable Long id, @RequestBody Mesa mesaAtualizada) {
        return mesaService.atualizarMesa(id, mesaAtualizada);
    }

    @DeleteMapping("/{id}")
    public void removerMesa(@PathVariable Long id) {
        mesaService.removerMesa(id);
    }
}
