package com.ms.user.repositories;
// UserRepository.java
import com.ms.user.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;
// Repositorio para a entidade UserModel, estendendo JpaRepository para fornecer operações CRUD e outras funcionalidades de acesso a dados
public interface UserRepository extends JpaRepository<UserModel, UUID> {
}