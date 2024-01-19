package com.solinfbroker.apigeral.service;

import com.solinfbroker.apigeral.config.exceptions.RecursoNaoAceitoException;
import com.solinfbroker.apigeral.model.*;
import com.solinfbroker.apigeral.repository.ClienteRepository;
import com.solinfbroker.apigeral.repository.OrdemRepository;
import com.solinfbroker.apigeral.model.ClienteModel;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import com.solinfbroker.apigeral.dtos.OrdemDTO;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class OrdemServiceTest {
    @Mock
    private OrdemRepository ordemRepository;
    @InjectMocks
    private OrdemService ordemService;

    @Test
    void testListarOrdemSucesso() {
        // Inicializa os mocks
        MockitoAnnotations.openMocks(this);

        List<Ordem> listaFake = Arrays.asList(
                new Ordem()
        );

        // Configura o mock para retornar a lista fake
        when(ordemRepository.findAll()).thenReturn(listaFake);

        // Chama o método que você está testando
        List<Ordem> listaRetornada = ordemService.listarOrdem();

        // Asserts para verificar se a lista retornada é a esperada
        assertNotNull(listaRetornada);
        assertEquals(1, listaRetornada.size());
    }

    @Test
    void testListarOrdemErro() {
        // Inicializa os mocks
        MockitoAnnotations.openMocks(this);

        List<Ordem> listaFake = Arrays.asList(
                new Ordem()
        );

        // Configura o mock para retornar a lista fake
        when(ordemRepository.findAll()).thenReturn(listaFake);

        // Chama o método que você está testando
        List<Ordem> listaRetornada = ordemService.listarOrdem();

        // Asserts para verificar se a lista retornada é a esperada
        assertNotNull(listaRetornada);
        assertNotEquals(0, listaRetornada.size());
    }

    @Test
    void testBuscarOrdemSucesso() {
    }

    @Test
    void testBuscarOrdemErro() {
    }

    @Test
    void testCriarOrdemSucesso() {
    }

    @Test
    void testCriarOrdemErro() {

        OrdemDTO ordem = mock(OrdemDTO.class);
        Optional<ClienteModel> cliente = mock(Optional.of(new ClienteModel()));

        when(clienteRepository.findById(any())).thenReturn(Optional.of());

        when(ordem.tipoOrdem()).thenReturn(enumTipoOrdem.ORDEM_COMPRA);
        when(cliente.isPresent()).thenReturn(true);
        when(cliente.get().getSaldo()).thenReturn(10.0);
        when(ordem.valorOrdem()).thenReturn(2.0);
        when(ordem.quantidadeOrdem()).thenReturn(2);

        assertThrows(RecursoNaoAceitoException.class, () -> {
            ordemService.criarOrdem(ordem);
        });
    }

    @Test
    void testCancelarOrdemSucesso() {

    }

    @Test
    void testCancelarOrdemErro() {
    }
}