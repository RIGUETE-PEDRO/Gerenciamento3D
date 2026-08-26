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
@Table(name = "pedido")
public class PedidoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Column(name = "categoria", nullable = false)
    private String categoria;

    @Column(name = "material", nullable = false)
    private String material;

    @Column(name = "cor", nullable = false)
    private String cor;

    @Column(name = "prazo_producao", nullable = false)
    private Integer prazoProducao;

    @Column(name = "quantidade", nullable = false)
    private Integer quantidade;

    @Column(name = "valor_unitario", nullable = false)
    private Double valorUnitario;

    protected PedidoEntity() {
    }

    public PedidoEntity(String nome, String descricao, String categoria, String material, String cor,
            Integer prazoProducao, Integer quantidade, Double valorUnitario) {
        this.nome = nome;
        this.descricao = descricao;
        this.categoria = categoria;
        this.material = material;
        this.cor = cor;
        this.prazoProducao = prazoProducao;
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
    }
}
