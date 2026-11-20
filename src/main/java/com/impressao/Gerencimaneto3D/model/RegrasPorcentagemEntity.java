package com.impressao.Gerencimaneto3D.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity 
@Getter 
@Setter 
@Table (name = "regrasPorcetagem")
public class RegrasPorcentagemEntity {
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column (name = "porcentagem", nullable = false)
    private Double porcentagem;

    public RegrasPorcentagemEntity() {
    }
    
    public RegrasPorcentagemEntity(String nome, Double porcentagem) {
        this.nome = nome;
        this.porcentagem = porcentagem;
    }

}
