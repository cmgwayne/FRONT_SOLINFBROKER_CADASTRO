package com.solinfbroker.apigeral.dtos;

import com.solinfbroker.apigeral.model.enumTipoOrdem;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Min;

public record OrdemDTO(

        @Column(name = "id_cliente", nullable = false)
        Long idCliente,

        @Column(name = "id_ativo", nullable = false)
        Long idAtivo,

        @Column(name = "tipo_ordem", nullable = false, length = 12)
        @Enumerated(EnumType.STRING)
        enumTipoOrdem tipoOrdem,

        @Column(name = "valor_ordem", nullable = false)
        @Min(1)
        double valorOrdem,

        @Column(name = "quantidade_ordem", nullable = false)
        @Min(1)
        Integer quantidadeOrdem

) {
}
