package com.impressao.Gerencimaneto3D.Request;

import jakarta.validation.constraints.NotBlank;

public record CadastroRequest(
        @NotBlank
        String nome,
                
        @NotBlank
        String senha,
                
        @NotBlank
        String email
        ) {

}
