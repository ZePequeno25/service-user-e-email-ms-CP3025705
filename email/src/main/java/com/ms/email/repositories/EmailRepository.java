package com.ms.email.repositories;

import com.ms.email.models.EmailModel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;
// Interface de repositório para a entidade EmailModel, estendendo JpaRepository para operações CRUD
public interface EmailRepository extends JpaRepository<EmailModel, UUID> {
}