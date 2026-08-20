package com.impressao.Gerencimaneto3D.Request;

import jakarta.validation.constraints.NotBlank;

public record LoginRequest(
        @NotBlank
        String username,
                
        @NotBlank 
        String password
) {
}