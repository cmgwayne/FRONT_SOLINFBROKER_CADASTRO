package com.solinfbroker.apigeral.controller;

import com.solinfbroker.apigeral.config.exceptions.RecursoNaoEncontradoException;
import com.solinfbroker.apigeral.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteController {

//    @Autowired
//    private KafkaProducerMessage kafkaProducerMessage;

    @Autowired
    ClienteService clienteService;

    @GetMapping("/{id}")
    private ResponseEntity<?> buscarCliente(@PathVariable Long id){
        return clienteService.buscarCliente(id).map(ResponseEntity::ok)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Cliente", "id", id));
    }

    @PutMapping("/adicionar-saldo/{id}")
    private ResponseEntity adicionarSaldo(@PathVariable Long id, @RequestParam(value = "valor")double valor ){
        return ResponseEntity.ok(clienteService.addSaldo(id,valor));
    }

    @PutMapping("/sacar-saldo/{id}")
    private ResponseEntity sacarSaldo(@PathVariable Long id, @RequestParam(value = "valor")double valor ){
        return ResponseEntity.ok(clienteService.sacarSaldo(id,valor));
    }
}
