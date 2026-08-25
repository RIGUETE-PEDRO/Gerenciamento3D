package com.impressao.Gerencimaneto3D.repository;

import com.impressao.Gerencimaneto3D.model.MaterialEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaterialRepository extends JpaRepository<MaterialEntity, Long> {
}