package com.vaibhav.user_crud.service;

import com.vaibhav.user_crud.model.User;
import com.vaibhav.user_crud.repository.UserRepository;
import com.vaibhav.user_crud.response.UserRequestDTO;
import com.vaibhav.user_crud.response.UserResponseDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    // Create or update a user
    public UserResponseDTO saveUser(UserRequestDTO userRequestDTO) {
        User user=new User(userRequestDTO.getFirstName(),
                userRequestDTO.getLastName(), userRequestDTO.getEmailId(),
                userRequestDTO.getCreatedAt(), userRequestDTO.getCreatedBy(),
                userRequestDTO.getUpdatedAt(), userRequestDTO.getUpdatedBy());
        return new UserResponseDTO(userRepository.save(user));
    }

    // Get all users
    public List<UserResponseDTO> getAllUsers() {
        List<User> user=userRepository.findAll();
        return user.stream().map(UserResponseDTO::new).toList();
    }

    // Get user by ID
    public Optional<UserResponseDTO> getUserById(long id) {
        Optional<User> user=userRepository.findById(id);
        return user.map(UserResponseDTO::new);
    }

    // Delete user by ID
    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }

    // Update user (assuming user already exists)
    public UserResponseDTO updateUser(long id, UserRequestDTO userRequestDTO) {
        userRepository.findById(id)
               .map(user-> {
        user.setFirstName(userRequestDTO.getFirstName());
        user.setLastName(userRequestDTO.getLastName());
        user.setUpdatedAt(LocalDate.now());
        user.setUpdatedBy(userRequestDTO.getUpdatedBy());
        return userRepository.save(user); });
        return null;
    }
}

