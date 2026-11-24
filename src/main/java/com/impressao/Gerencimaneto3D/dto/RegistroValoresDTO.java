package com.impressao.Gerencimaneto3D.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistroValoresDTO {
    private List<RegistroPorcentagemDTO> registroPorcentagemDTOList;
    private double valor;

}
