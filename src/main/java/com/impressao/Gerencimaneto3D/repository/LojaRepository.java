package com.impressao.Gerencimaneto3D.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.impressao.Gerencimaneto3D.model.LojaEntity;

public interface LojaRepository extends JpaRepository<LojaEntity, Long> {
    List<LojaEntity> findAllByOrderByNomeAsc();
}
