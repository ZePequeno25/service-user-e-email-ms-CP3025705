package com.ms.user.dtos;
// EmailDto.java
import java.util.UUID;
// Data Transfer Object (DTO) for email information, used to transfer email-related data between different layers of the application
public class EmailDto {
    private UUID userId;
    private String emailTo;
    private String subject;
    private String text;

    // Getters e Setters
    public UUID getUserId() { return userId; }
    public void setUserId(UUID userId) { this.userId = userId; }
    public String getEmailTo() { return emailTo; }
    public void setEmailTo(String emailTo) { this.emailTo = emailTo; }
    public String getSubject() { return subject; }
    public void setSubject(String subject) { this.subject = subject; }
    public String getText() { return text; }
    public void setText(String text) { this.text = text; }
}