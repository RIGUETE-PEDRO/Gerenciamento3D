package com.impressao.Gerencimaneto3D.dto;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter 

public class PorcetagemDTO {
 
    private String nome;
    private Double valor;

    public PorcetagemDTO() {
    }

    public PorcetagemDTO(String nome, Double porcentagem) {
        this.nome = nome;
        this.valor = porcentagem;
    }
}
