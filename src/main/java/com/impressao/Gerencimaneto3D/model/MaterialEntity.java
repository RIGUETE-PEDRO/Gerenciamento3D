package com.impressao.Gerencimaneto3D.model;

import java.time.LocalDate;

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
@Table(name = "filamentos")
public class MaterialEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "tipo", nullable = false)
    private String tipo;

    @Column(name = "cor", nullable = false)
    private String cor;

    @Column(name = "valor", nullable = false)
    private double custo;

    @Column(name = "quantidade", nullable = false)
    private int quantidade;

    @Column(name = "loja_id", nullable = false)
    private Long lojaId;

    @Column(name = "data_compra", nullable = false)
    private LocalDate dataCompra;

    protected MaterialEntity() {
    }

    public MaterialEntity(String nome, String tipo, String cor, double custo,
            int quantidade, Long lojaId, LocalDate dataCompra) {
        this.nome = nome;
        this.tipo = tipo;
        this.cor = cor;
        this.custo = custo;
        this.quantidade = quantidade;
        this.lojaId = lojaId;
        this.dataCompra = dataCompra;
    }

    
}
