package com.impressao.Gerencimaneto3D.Request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public record RegrasPorcetagemEntity(

    @NotBlank(message = "O nome da regra é obrigatório")
    String nome,

    @NotNull(message = "A porcentagem da regra é obrigatória")
    @PositiveOrZero(message = "A porcentagem não pode ser negativa")
    Double porcentagem

) {
}