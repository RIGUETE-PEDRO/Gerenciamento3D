package com.impressao.Gerencimaneto3D.Request;

import java.math.BigDecimal;
import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public record RegistroPorcentagemRequest(
    
    @NotBlank
    String nome,

    @NotNull
    @PositiveOrZero
    BigDecimal valor
) {
}

