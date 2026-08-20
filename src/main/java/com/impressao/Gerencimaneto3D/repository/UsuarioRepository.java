package com.impressao.Gerencimaneto3D.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.impressao.Gerencimaneto3D.model.UsuarioEntity;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {

    Optional<UsuarioEntity> findByEmail(String email);
}