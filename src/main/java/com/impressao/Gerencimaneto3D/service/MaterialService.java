package com.impressao.Gerencimaneto3D.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.impressao.Gerencimaneto3D.Request.MaterialRequest;
import com.impressao.Gerencimaneto3D.model.MaterialEntity;
import com.impressao.Gerencimaneto3D.repository.MaterialRepository;

@Service
public class MaterialService {

    private final MaterialRepository materialRepository;

    public MaterialService(MaterialRepository materialRepository) {
        this.materialRepository = materialRepository;
    }


    public boolean cadastrarMaterial(MaterialRequest request) {
        MaterialEntity material = new MaterialEntity(
                request.nome(),
                request.tipo(),
                request.cor(),
                request.custo(),
                request.quantidade(),
                request.lojaId(),
                request.dataCompra()
            );

        materialRepository.save(material);

        return true;
    }


    public List<MaterialEntity> listarMateriais() {
        return materialRepository.findAll();
    }

    public boolean atualizarMaterial(Long id, MaterialRequest request) {
        return materialRepository.findById(id).map(material -> {
            material.setNome(request.nome());
            material.setTipo(request.tipo());
            material.setCor(request.cor());
            material.setCusto(request.custo());
            material.setQuantidade(request.quantidade());
            material.setLojaId(request.lojaId());
            material.setDataCompra(request.dataCompra());
            materialRepository.save(material);
            return true;
        }).orElse(false);
    }

    public boolean excluirMaterial(Long id) {
        if (!materialRepository.existsById(id)) {
            return false;
        }
        materialRepository.deleteById(id);
        return true;
    }
    
 
    
}
