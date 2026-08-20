package com.impressao.Gerencimaneto3D.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.impressao.Gerencimaneto3D.Request.LoginRequest;
import com.impressao.Gerencimaneto3D.model.UsuarioEntity;
import com.impressao.Gerencimaneto3D.repository.UsuarioRepository;

@Service
public class LoginSevice {

    private final PasswordEncoder passwordEncoder;
    private final UsuarioRepository usuarioRepository;

    public LoginSevice(
            PasswordEncoder passwordEncoder,
            UsuarioRepository usuarioRepository) {

        this.passwordEncoder = passwordEncoder;
        this.usuarioRepository = usuarioRepository;
    }

    public boolean login(LoginRequest loginRequest) {

        UsuarioEntity usuario = usuarioRepository
                .findByEmail(loginRequest.username())
                .orElse(null);

        if (usuario == null) {
            return false;
        }

        return passwordEncoder.matches(
                loginRequest.password(),
                usuario.getSenha());
    }

    
}
