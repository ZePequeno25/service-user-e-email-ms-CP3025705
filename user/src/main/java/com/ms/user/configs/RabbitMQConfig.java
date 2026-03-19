package com.ms.user.configs;
// RabbitMQConfig.java
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
// RabbitMQ configuration class to set up the message converter for JSON serialization
@Configuration
public class RabbitMQConfig {
    // Bean definition for the message converter that uses Jackson to convert messages to JSON format
    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
        ObjectMapper objectMapper = new ObjectMapper();
        return new Jackson2JsonMessageConverter(objectMapper);
    }
}