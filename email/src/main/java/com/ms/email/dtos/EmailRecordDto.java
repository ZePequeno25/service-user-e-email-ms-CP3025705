package com.ms.email.dtos;

import java.util.UUID;
// Record DTO para transferência de dados de email, contendo os campos necessários para criar um email
public record EmailRecordDto(
        UUID userId,
        String emailTo,
        String subject,
        String text
) { }