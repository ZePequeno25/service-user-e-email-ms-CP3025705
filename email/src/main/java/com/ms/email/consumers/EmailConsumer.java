package com.ms.email.consumers;
// Importações necessárias para o consumidor de email
import com.ms.email.dtos.EmailRecordDto;
import com.ms.email.models.EmailModel;
import com.ms.email.services.EmailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
// Componente para consumir mensagens da fila de email, processando os dados recebidos e enviando os emails
@Component
public class EmailConsumer {
    // Injeção de dependências do serviço de email
    private final EmailService emailService;
    // Construtor para injeção de dependências do serviço de email
    public EmailConsumer(EmailService emailService) {
        this.emailService = emailService;
    }
    // Método para ouvir a fila de email e processar as mensagens recebidas
    @RabbitListener(queues = "${broker.queue.email.name}")
    public void listenEmailQueue(@Payload EmailRecordDto emailRecordDto) {
        var emailModel = new EmailModel();
        BeanUtils.copyProperties(emailRecordDto, emailModel);
        emailService.sendEmail(emailModel);
        System.out.println("Email enviado e registrado: " + emailModel.getEmailTo());
    }
}