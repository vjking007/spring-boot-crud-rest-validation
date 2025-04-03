package com.vaibhav.user_crud.controller;

import com.vaibhav.user_crud.model.User;
import com.vaibhav.user_crud.response.UserRequestDTO;
import com.vaibhav.user_crud.response.UserResponseDTO;
import com.vaibhav.user_crud.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService=userService;
    }

    // Create a new user
    @PostMapping("/save")
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody UserRequestDTO userRequestDTO) {
        UserResponseDTO responseDTO = userService.saveUser(userRequestDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    // Get all users
    @GetMapping("/fetch")
    public ResponseEntity<List<UserResponseDTO>> getAllUsers() {
        List<UserResponseDTO> userResponseDTOS = userService.getAllUsers();
        return new ResponseEntity<>(userResponseDTOS, HttpStatus.OK);
    }

    // Get user by ID
    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable long id) {
        Optional<UserResponseDTO> userById = userService.getUserById(id);
        return userById.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Update an existing user
    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDTO> updateUser(@PathVariable long id, @RequestBody UserRequestDTO userRequestDTO) {
        UserResponseDTO updatedUser = userService.updateUser(id, userRequestDTO);
        return updatedUser != null ? new ResponseEntity<>(updatedUser, HttpStatus.OK)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    // Delete user by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable long id) {
        userService.deleteUser(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
