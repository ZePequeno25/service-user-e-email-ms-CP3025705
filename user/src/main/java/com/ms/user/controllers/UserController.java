package com.ms.user.controllers;
// UserController.java
import com.ms.user.dtos.UserRecordDto;
import com.ms.user.models.UserModel;
import com.ms.user.services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
// REST controller to handle user-related HTTP requests
@RestController
@RequestMapping("/users")
public class UserController {
    // Service layer dependency to handle business logic related to users
    private final UserService userService;
    // Constructor-based dependency injection for the UserService
    public UserController(UserService userService) {
        this.userService = userService;
    }
    // Endpoint to create a new user, accepting a UserRecordDto in the request body and returning the created UserModel
    @PostMapping
    public ResponseEntity<UserModel> saveUser(@RequestBody @Valid UserRecordDto userRecordDto) {
        var userModel = new UserModel();
        // Converter DTO para Model (usaremos BeanUtils)
        if (userRecordDto != null) {
            org.springframework.beans.BeanUtils.copyProperties(userRecordDto, userModel);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(userModel));
    }
}