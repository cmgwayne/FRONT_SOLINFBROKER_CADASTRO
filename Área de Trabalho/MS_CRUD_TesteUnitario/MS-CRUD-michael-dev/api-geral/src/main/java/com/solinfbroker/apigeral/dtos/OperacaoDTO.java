package com.solinfbroker.apigeral.dtos;

import com.solinfbroker.apigeral.model.enumStatus;
import com.solinfbroker.apigeral.model.enumTipoOrdem;
import jakarta.persistence.*;

import java.time.LocalDateTime;

public record OperacaoDTO(

        @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id,
        @Column(name = "quantidade",nullable = false)
    Integer quantidade,
        @Column(name = "data_execucao",nullable = false)
    LocalDateTime dataExecucao,
        @Enumerated(EnumType.STRING)
    @Column(name = "status_operacao",nullable = false)
    enumStatus statusOperacao,
    @Column(name = "tipo_ordem", nullable = false, length = 12)
    @Enumerated(EnumType.STRING)
    enumTipoOrdem tipoOrdem //TODO adicionar um inner join

) {
}
