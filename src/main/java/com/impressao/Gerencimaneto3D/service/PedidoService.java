package com.impressao.Gerencimaneto3D.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.impressao.Gerencimaneto3D.Request.PedidoRequest;
import com.impressao.Gerencimaneto3D.model.PedidoEntity;
import com.impressao.Gerencimaneto3D.repository.PedidoRepository;

import jakarta.validation.Valid;

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

    public boolean deletarPedido(Long id) {
        if (pedidoRepository.existsById(id)) {
            pedidoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public boolean atualizarPedido(Long id, PedidoRequest request) {
        PedidoEntity pedidoExistente = pedidoRepository.findById(id).orElse(null);
        if (pedidoExistente != null) {
            pedidoExistente.setNome(request.nome());
            pedidoExistente.setDescricao(request.descricao());
            pedidoExistente.setCategoria(request.categoria());
            pedidoExistente.setMaterial(request.material());
            pedidoExistente.setCor(request.cor());
            pedidoExistente.setPrazoProducao(request.prazoProducao());
            pedidoExistente.setQuantidade(request.quantidade());
            pedidoExistente.setValorUnitario(request.valorUnitario());

            pedidoRepository.save(pedidoExistente);
            return true;
        }
        return false;
    }
    
}
