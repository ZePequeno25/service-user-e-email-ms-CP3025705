package com.ms.user.services;
// UserService.java
import com.ms.user.models.UserModel;
import com.ms.user.producers.UserProducer;
import com.ms.user.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
// Serviço para gerenciar as operações relacionadas aos usuários, incluindo a lógica de negócios para salvar um usuário e publicar mensagens relacionadas a ele
@Service
public class UserService {
    // Dependências do repositório para acessar os dados dos usuários e do produtor para enviar mensagens relacionadas a usuários
    private final UserRepository userRepository;
    private final UserProducer userProducer;
    // Construtor para injetar as dependências do UserRepository e UserProducer
    public UserService(UserRepository userRepository, UserProducer userProducer) {
        this.userRepository = userRepository;
        this.userProducer = userProducer;
    }
    // Método para salvar um usuário, que também publica uma mensagem de email no RabbitMQ usando o UserProducer. O método é anotado com @Transactional para garantir que as operações de banco de dados sejam tratadas como uma única transação.
    @Transactional
    public UserModel save(UserModel userModel) {
        if (userModel == null) {
            throw new IllegalArgumentException("UserModel cannot be null");
        }
        userProducer.publishMessageEmail(userModel);
        return userRepository.save(userModel);
    }
}