package com.impressao.Gerencimaneto3D.Request;

import com.fasterxml.jackson.annotation.JsonAlias;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record PedidoRequest(
    @NotNull(message = "O nome do pedido é obrigatório")
    @JsonAlias("Nome")
    String nome,

    @NotNull(message = "A descrição do pedido é obrigatória")
    String descricao,

    @NotNull(message = "A categoria do pedido é obrigatória")
    String categoria,

    @NotNull(message = "O material do pedido é obrigatório")
    String material,

    @NotNull(message = "A cor do pedido é obrigatória")
    String cor,

    @NotNull(message = "O prazo de produção do pedido é obrigatório")
    @Positive(message = "O prazo de produção deve ser maior que zero")
    Integer prazoProducao,

    @NotNull(message = "A quantidade do pedido é obrigatória")
    @Positive(message = "A quantidade deve ser maior que zero")
    Integer quantidade,

    @NotNull(message = "O valor unitário do pedido é obrigatório")
    @Positive(message = "O valor unitário deve ser maior que zero")
    Double valorUnitario
) {}
