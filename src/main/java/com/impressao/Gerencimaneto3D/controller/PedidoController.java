package com.impressao.Gerencimaneto3D.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.impressao.Gerencimaneto3D.Request.PedidoRequest;
import com.impressao.Gerencimaneto3D.service.PedidoService;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {
    
    private final PedidoService pedidoService;
    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @PostMapping("/cadastrar")
    public String Cadastrar(@Valid @RequestBody PedidoRequest request) {
        boolean sucesso = pedidoService.cadastrarPedido(request);
        if (!sucesso) {
            return "Erro ao cadastrar pedido";
        }
        return "Pedido cadastrado com sucesso";
        
        
    }

    @PutMapping ("/atualizar/{id}")
    public ResponseEntity<String> atualizar(@Valid @RequestBody PedidoRequest request, @PathVariable Long id) {
        boolean sucesso = pedidoService.atualizarPedido(id, request);
        if (!sucesso) {
            return ResponseEntity.status(400).body("Erro ao atualizar pedido");
        }
        return ResponseEntity.ok("Pedido atualizado com sucesso");
    }

    @DeleteMapping ("/deletar/{id}")
    public ResponseEntity<String> deletar(@PathVariable Long id) {
        boolean sucesso = pedidoService.deletarPedido(id);
        if (!sucesso) {
            return ResponseEntity.status(400).body("Erro ao deletar pedido");
        }
        return ResponseEntity.ok("Pedido deletado com sucesso");
    }
    
    
    @GetMapping("/listar")
    public ResponseEntity<?> getMethodName() {
        var pedido = pedidoService.findPedidoAll();
        return ResponseEntity.ok(pedido);

        
    }
    
}
