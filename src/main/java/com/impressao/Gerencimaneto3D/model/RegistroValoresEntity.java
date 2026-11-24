package com.impressao.Gerencimaneto3D.model;

import java.time.LocalDateTime;
import java.time.ZoneId;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "registroValores")
public class RegistroValoresEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "valor", nullable = false)
    private Double valor;

    @Column(name = "data_calculo", nullable = false)
    private LocalDateTime dataCalculo;

    public RegistroValoresEntity() {
    }

    public RegistroValoresEntity(Double valor) {
        this.valor = valor;
        this.dataCalculo = LocalDateTime.now(
            ZoneId.of("America/Sao_Paulo")
        );
    }
}