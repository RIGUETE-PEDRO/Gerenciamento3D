package com.impressao.Gerencimaneto3D.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.impressao.Gerencimaneto3D.Request.MaterialRequest;
import com.impressao.Gerencimaneto3D.model.MaterialEntity;
import com.impressao.Gerencimaneto3D.service.MaterialService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/material")
public class MaterialController {
    private final MaterialService materialService;

    public MaterialController(MaterialService materialService) {
        this.materialService = materialService;
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<String> cadastrarMaterial(@Valid @RequestBody MaterialRequest request) {

        boolean sucesso = materialService.cadastrarMaterial(request);

        if (!sucesso) {
            return ResponseEntity
                    .status(400)
                    .body("Erro ao cadastrar material");
        }
        return ResponseEntity
                .status(200)
                .body("Material cadastrado com sucesso");
    }
    
    @GetMapping("/listar")
    public ResponseEntity<?> listarMateriais() {
        MaterialEntity materiais = materialService.listarMateriais();
        return ResponseEntity.ok(materiais);
    }
   
}