package com.solinfbroker.apigeral.service;

import com.solinfbroker.apigeral.config.kafka.Topicos;
import lombok.SneakyThrows;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class KafkaListener {

    private final Logger LOG = LoggerFactory.getLogger(KafkaListener.class);

    @org.springframework.kafka.annotation.KafkaListener(topics = Topicos.TOPIC_ATUALIZACAO_MERCADO,  groupId = Topicos.TOPIC_ATUALIZACAO_MERCADO)
    public void listeningAtualizacaoMercado(ConsumerRecord<String, String> record)  {
        LOG.info("CONSUMER message from Kafka: {}", record.value());

        /* Business rule code with message */
    }

    @SneakyThrows
    @org.springframework.kafka.annotation.KafkaListener(topics = Topicos.TOPIC_INFO_USUARIO,  groupId = Topicos.TOPIC_INFO_USUARIO)
    public void listeningInfoUsuario(ConsumerRecord<String, String> record)  {
        LOG.info("CONSUMER message from Kafka: {}", record.value());

        /* Business rule code with message */
    }

    @SneakyThrows
    @org.springframework.kafka.annotation.KafkaListener(topics = Topicos.TOPIC_CHECK_SAUDE,  groupId = Topicos.TOPIC_CHECK_SAUDE)
    public void listeningSaudeCheck(ConsumerRecord<String, String> record)  { //Adicionar o Objeto que desejo receber, no lugar da segunda string, este objeto será um DTO novo com a adição do campo __op
        LOG.info("CONSUMER message from Kafka: {}", record.value());

        /* Business rule code with message */
    }

    @SneakyThrows
    @org.springframework.kafka.annotation.KafkaListener(topics = Topicos.TOPIC_ATUALIZACAO_TESTES,  groupId = Topicos.TOPIC_ATUALIZACAO_TESTES)
    public void listeningAtualizacaoTeste(ConsumerRecord<String, String> record)  {
        LOG.info("CONSUMER message from Kafka: {}", record.value());

        /* Business rule code with message */
    }

    @SneakyThrows
    @org.springframework.kafka.annotation.KafkaListener(topics = Topicos.DB_CLIENTE,  groupId = Topicos.DB_CLIENTE)
    public void listeningAtualizacaoBanco(ConsumerRecord<String, String> record)  {
        LOG.info("ClienteController: {}", record.value());
        /* Business rule code with message */
    }

}

