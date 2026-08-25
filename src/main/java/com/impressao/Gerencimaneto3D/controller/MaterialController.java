package com.impressao.Gerencimaneto3D.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.impressao.Gerencimaneto3D.Request.MaterialRequest;
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
        var materiais = materialService.listarMateriais();
        return ResponseEntity.ok(materiais);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<String> editarMaterial(
            @PathVariable Long id,
            @Valid @RequestBody MaterialRequest request) {
        if (!materialService.atualizarMaterial(id, request)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("Material atualizado com sucesso");
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<String> excluirMaterial(@PathVariable Long id) {
        if (!materialService.excluirMaterial(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("Material excluído com sucesso");
    }
   
}
