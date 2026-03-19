package com.ms.email.configs;
// Importações necessárias para a configuração do RabbitMQ
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
// Configuração do RabbitMQ para a aplicação, definindo a fila de email e o conversor de mensagens
@Configuration
public class RabbitMQConfig {
    // Injeção do nome da fila de email a partir das propriedades de configuração
    @Value("${broker.queue.email.name}")
    private String queue;
    // Bean para criar a fila de email, garantindo que ela seja durável
    @Bean
    public Queue queue() {
        return new Queue(queue, true);
    }
    // Bean para converter mensagens usando Jackson, permitindo a serialização e desserialização de objetos JSON
    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
        ObjectMapper objectMapper = new ObjectMapper();
        return new Jackson2JsonMessageConverter(objectMapper);
    }
}