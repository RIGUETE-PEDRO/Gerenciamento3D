package com.impressao.Gerencimaneto3D.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.impressao.Gerencimaneto3D.Request.CalcularRequest;
import com.impressao.Gerencimaneto3D.Request.RegistrarValoresRequest;
import com.impressao.Gerencimaneto3D.dto.PorcetagemDTO;
import com.impressao.Gerencimaneto3D.model.RegrasPorcentagemEntity;
import com.impressao.Gerencimaneto3D.repository.RegrasPorcetagemRepository;

import jakarta.validation.Valid;

@Service 
public class CalcularService {
    
    private final RegrasPorcetagemRepository regraRepository;

    public CalcularService( RegrasPorcetagemRepository regraRepository) {
       
        this.regraRepository = regraRepository;
    }

    public boolean atualizar(Long id, RegrasPorcentagemEntity regra) {
        RegrasPorcentagemEntity regraExistente = regraRepository.findById(id).orElse(null);
        if (regraExistente != null) {
            regraExistente.setPorcentagem(regra.getPorcentagem());
            regraExistente.setNome(regra.getNome());
            regraRepository.save(regraExistente);
            return true;
        }
        return false;
    }

    public ArrayList<PorcetagemDTO> calcular(Double valor) {
        ArrayList<PorcetagemDTO> porcentagens = new ArrayList<>();
        for (RegrasPorcentagemEntity regra : regraRepository.findAll()) {
            double resultado = valor * (regra.getPorcentagem() / 100);
            porcentagens.add(new PorcetagemDTO(regra.getNome(), resultado));
        }
        
        return porcentagens;
    }

    public void cadastrarcalcular(String nome, double porcentagem) {
        List<RegrasPorcentagemEntity> regrasExistentes = regraRepository.findAll();

        double totalPorcentagem = regrasExistentes.stream()
                .mapToDouble(RegrasPorcentagemEntity::getPorcentagem)
                .sum();
        if(totalPorcentagem + porcentagem > 100) {
            throw new IllegalArgumentException("A soma das porcentagens não pode ultrapassar 100%");
        }

        RegrasPorcentagemEntity regra = new RegrasPorcentagemEntity(nome, porcentagem);
        regra.setNome(nome);
        regra.setPorcentagem(porcentagem);
        regraRepository.save(regra);
    }

    public ArrayList<RegrasPorcentagemEntity> listar() {
        return (ArrayList<RegrasPorcentagemEntity>) regraRepository.findAll();
    }

    public boolean deletar(Long id) {
        if (regraRepository.existsById(id)) {
            regraRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public boolean salvarCalculo(RegistrarValoresRequest request) {
        

        
        return false;
    }
}
