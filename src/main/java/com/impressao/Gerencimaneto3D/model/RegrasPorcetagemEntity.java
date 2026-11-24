package com.impressao.Gerencimaneto3D.model;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter 
@Entity 
@Table (name = "regrasPorcetagem")
public class RegrasPorcetagemEntity {
    
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "nome", nullable = false)
    private String nome;

    @Column (name = "porcentagem", nullable = false)
    private Double porcentagem;

    @Column (name = "data_criacao", nullable = false)
    private Timestamp dataCriacao;

    @ManyToOne 
    @JoinColumn (name = "id_RegistroValores", nullable = false)
    private RegistroValoresEntity registroValores;

    public RegrasPorcetagemEntity(String nome, Double porcentagem, Timestamp dataCriacao, RegistroValoresEntity registroValores) {
        this.nome = nome;
        this.porcentagem = porcentagem;
        this.dataCriacao = dataCriacao;
        this.registroValores = registroValores;
    }

}
