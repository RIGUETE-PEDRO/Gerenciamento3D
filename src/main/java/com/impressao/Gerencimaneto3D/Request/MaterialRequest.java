package com.impressao.Gerencimaneto3D.Request;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record MaterialRequest(
    
    @NotNull(message = "O nome do material é obrigatório")
    String nome,
            
    @NotNull(message = "O tipo do material é obrigatório")
    String tipo,
            
    @NotNull(message = "A cor do material é obrigatória")
    String cor,
            
    @NotNull(message = "O preço do material é obrigatório")
    @Positive(message = "O preço deve ser maior que zero")
    Double custo,
            
    @NotNull(message = "A quantidade do material é obrigatória")
    @Positive(message = "A quantidade deve ser maior que zero")
    Integer quantidade,
    
    @NotNull(message = "O id da loja é obrigatório")
    Long lojaId,

    @NotNull(message = "A data da compra é obrigatória")
    LocalDate dataCompra
) {}
    
