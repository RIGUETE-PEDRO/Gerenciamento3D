package com.impressao.Gerencimaneto3D.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.impressao.Gerencimaneto3D.Request.PedidoRequest;
import com.impressao.Gerencimaneto3D.service.PedidoService;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
    
    
    @GetMapping("/listar")
    public ResponseEntity<?> getMethodName() {
        var pedido = pedidoService.findPedidoAll();
        return ResponseEntity.ok(pedido);

        
    }
    
}
