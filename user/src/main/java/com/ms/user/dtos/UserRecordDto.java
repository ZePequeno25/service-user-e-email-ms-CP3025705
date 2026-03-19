package com.ms.user.dtos;
// UserRecordDto.java
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
// Data Transfer Object (DTO) for user information, used to transfer user-related data between different layers of the application
public record UserRecordDto(
        @NotBlank String name,
        @NotBlank @Email String email
) { }