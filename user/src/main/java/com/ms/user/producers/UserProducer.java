package com.ms.user.producers;
// UserProducer.java
import com.ms.user.dtos.EmailDto;
import com.ms.user.models.UserModel;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
// Componente Spring para produzir mensagens relacionadas a usuários, especificamente para enviar informações de email para uma fila RabbitMQ quando um novo usuário é criado.
@Component
public class UserProducer {
    // Dependência do RabbitTemplate para enviar mensagens para o RabbitMQ
    private final RabbitTemplate rabbitTemplate;
    // Construtor para injetar o RabbitTemplate
    public UserProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }
    // Valor da chave de roteamento para a fila de email, injetado a partir das propriedades de configuração
    @Value("${broker.queue.email.name}")
    private String routingKey;
    // Método para publicar uma mensagem de email no RabbitMQ, criando um EmailDto com as informações do usuário e enviando-o para a fila configurada
    public void publishMessageEmail(UserModel userModel) {
        var emailDto = new EmailDto();
        emailDto.setUserId(userModel.getUserId());
        emailDto.setEmailTo(userModel.getEmail());
        emailDto.setSubject("Cadastro realizado com sucesso!");
        emailDto.setText(userModel.getName() + ", seja bem-vindo(a)! \nAgradecemos o seu cadastro, aproveite agora todos os recursos da nossa plataforma!");

        rabbitTemplate.convertAndSend("", routingKey, emailDto);
    }
}