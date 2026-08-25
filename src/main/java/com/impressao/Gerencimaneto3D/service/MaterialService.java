package com.impressao.Gerencimaneto3D.service;

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


    public MaterialEntity listarMateriais() {
        return materialRepository.findAll().stream().findFirst().orElse(null);
    }
    
 
    
}
