package com.impressao.Gerencimaneto3D.Request;

import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class RegistrarValoresRequest {
    @NotNull
    private Double valor;

    @NotEmpty
    @Valid
    private List<RegistroPorcentagemRequest> resultados;
}
