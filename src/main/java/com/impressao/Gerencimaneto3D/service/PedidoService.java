package com.impressao.Gerencimaneto3D.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.impressao.Gerencimaneto3D.Request.PedidoRequest;
import com.impressao.Gerencimaneto3D.model.PedidoEntity;
import com.impressao.Gerencimaneto3D.repository.PedidoRepository;

@Service
public class PedidoService {
    public final PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public List<PedidoEntity> findPedidoAll() {
        return pedidoRepository.findAll();
    }

    public boolean cadastrarPedido(PedidoRequest request) {
        PedidoEntity pedido = new PedidoEntity(
                request.nome(),
                request.descricao(),
                request.categoria(),
                request.material(),
                request.cor(),
                request.prazoProducao(),
                request.quantidade(),
                request.valorUnitario());

        pedidoRepository.save(pedido);

        return true;
    }
    
}
