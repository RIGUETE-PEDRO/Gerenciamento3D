package com.impressao.Gerencimaneto3D.repository;


import com.impressao.Gerencimaneto3D.model.PedidoEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<PedidoEntity, Long> {
}