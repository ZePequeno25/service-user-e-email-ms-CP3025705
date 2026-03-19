package com.ms.user.models;
// UserModel.java
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.UUID;
// Entity class representing the user data model, mapped to the "TB_USERS" table in the database
@Entity
@Table(name = "TB_USERS")
public class UserModel implements Serializable {
    private static final long serialVersionUID = 1L;
    // Primeiro campo é o ID, que é gerado automaticamente usando UUID
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID userId;
    private String name;
    private String email;

    // Getters e Setters
    public UUID getUserId() { return userId; }
    public void setUserId(UUID userId) { this.userId = userId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}