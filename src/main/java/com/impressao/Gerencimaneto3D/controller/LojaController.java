package com.impressao.Gerencimaneto3D.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.impressao.Gerencimaneto3D.model.LojaEntity;
import com.impressao.Gerencimaneto3D.repository.LojaRepository;

@RestController
@RequestMapping("/api/loja")
public class LojaController {
    private final LojaRepository lojaRepository;

    public LojaController(LojaRepository lojaRepository) {
        this.lojaRepository = lojaRepository;
    }

    @GetMapping("/listar")
    public List<LojaEntity> listar() {
        return lojaRepository.findAllByOrderByNomeAsc();
    }
}
