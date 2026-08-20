package com.impressao.Gerencimaneto3D.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.impressao.Gerencimaneto3D.Request.CadastroRequest;
import com.impressao.Gerencimaneto3D.model.UsuarioEntity;
import com.impressao.Gerencimaneto3D.repository.UsuarioRepository;

@Service
public class CadastroService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public CadastroService(
            UsuarioRepository usuarioRepository,
            PasswordEncoder passwordEncoder) {

        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public boolean cadastro(CadastroRequest cadastroRequest) {

        String senhaCriptografada = passwordEncoder.encode(
                cadastroRequest.senha()
        );

        UsuarioEntity usuario = new UsuarioEntity(
                cadastroRequest.nome(),
                senhaCriptografada,
                cadastroRequest.email()
        );

        usuarioRepository.save(usuario);

        return true;
    }
}
