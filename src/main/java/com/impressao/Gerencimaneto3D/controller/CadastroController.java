package com.impressao.Gerencimaneto3D.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.impressao.Gerencimaneto3D.Request.CadastroRequest;
import com.impressao.Gerencimaneto3D.service.CadastroService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth/cadastro")
public class CadastroController {

    private final CadastroService cadastroService;

    public CadastroController(CadastroService cadastroService) {
        this.cadastroService = cadastroService;
    }
    
    @PostMapping
    public ResponseEntity<String> cadastro(
            @Valid @RequestBody CadastroRequest cadastroRequest) {


        boolean sucesso = cadastroService.cadastro(cadastroRequest);

        if (!sucesso) {
            return ResponseEntity
                    .status(400)
                    .body("Erro ao cadastrar usuário");
        }

        return ResponseEntity.ok("Cadastro realizado com sucesso");
    }

}
