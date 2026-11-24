package com.impressao.Gerencimaneto3D.controller;

import java.util.ArrayList;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.impressao.Gerencimaneto3D.Request.CadastroRequest;
import com.impressao.Gerencimaneto3D.Request.CalcularRequest;
import com.impressao.Gerencimaneto3D.Request.RegistrarValoresRequest;
import com.impressao.Gerencimaneto3D.Request.RegrasPorcetagemEntity;
import com.impressao.Gerencimaneto3D.dto.PorcetagemDTO;
import com.impressao.Gerencimaneto3D.model.RegrasPorcentagemEntity;
import com.impressao.Gerencimaneto3D.service.CalcularService;
import com.impressao.Gerencimaneto3D.service.LoginSevice;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/calcular")
public class CalcularController {
    
    private final CalcularService calcularService;

    public CalcularController(CalcularService calcularService) {
        this.calcularService = calcularService;
    }

    @PostMapping
    public ResponseEntity<ArrayList<PorcetagemDTO>> calcular(@Valid @RequestBody CalcularRequest request ) {
        ArrayList<PorcetagemDTO> porcentagens = calcularService.calcular(request.getValor());
        return ResponseEntity.ok(porcentagens);

    }

    @PostMapping("/cadastro")
    public ResponseEntity<String> cadastro(@Valid @RequestBody RegrasPorcetagemEntity cadastroRequest) {

        calcularService.cadastrarcalcular(cadastroRequest.nome(), cadastroRequest.porcentagem());

        return ResponseEntity.ok("Login successful");
    }

    @GetMapping("/list")
    public ResponseEntity<ArrayList<RegrasPorcentagemEntity>> listar() {

        ArrayList<RegrasPorcentagemEntity> regras = calcularService.listar();

        return ResponseEntity.ok(regras);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletar(@PathVariable Long id) {
        boolean sucesso = calcularService.deletar(id);
        if (sucesso) {
            return ResponseEntity.ok("Regra deletada com sucesso");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> atualizar(@PathVariable Long id, @Valid @RequestBody RegrasPorcentagemEntity regra) {
        boolean sucesso = calcularService.atualizar(id, regra);
        if (sucesso) {
            return ResponseEntity.ok("Regra atualizada com sucesso");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping ("calcular/salvar")
    public ResponseEntity<String> salvar(@Valid @RequestBody RegistrarValoresRequest request) {
        boolean sucesso = calcularService.salvarCalculo(request);
        if (sucesso) {
            return ResponseEntity.ok("Valor salvo com sucesso");
        } else {
            return ResponseEntity.status(400).body("Erro ao salvar valor"); 
        }
    }

}