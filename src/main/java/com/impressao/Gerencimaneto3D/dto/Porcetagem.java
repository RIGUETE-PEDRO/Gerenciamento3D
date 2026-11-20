package com.impressao.Gerencimaneto3D.dto;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter 

public class Porcetagem {
 
    private String nome;
    private Double valor;

    public Porcetagem() {
    }

    public Porcetagem(String nome, Double porcentagem) {
        this.nome = nome;
        this.valor = porcentagem;
    }
}
