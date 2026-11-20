package com.impressao.Gerencimaneto3D.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CalcularRequest {

    @NotNull
    private Double valor;
}