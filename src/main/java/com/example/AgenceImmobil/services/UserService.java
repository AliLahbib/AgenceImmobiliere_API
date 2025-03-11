package com.example.AgenceImmobil.services;

import com.example.AgenceImmobil.entities.User;
import com.example.AgenceImmobil.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("An administrator with this email already exists!");
        }
        user.setRole("ADMINISTRATOR");
        return userRepository.save(user);
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User updateUser(Long id, User updatedUser) {
        return userRepository.findById(id).map(existingUser -> {
            copyNonNullProperties(updatedUser, existingUser);
            return userRepository.save(existingUser);
        }).orElseThrow(() -> new RuntimeException("User not found"));
    }
    private void copyNonNullProperties(User source, User target) {
        if (source.getFullname() != null) target.setFullname(source.getFullname());
        if (source.getEmail() != null) target.setEmail(source.getEmail());
        if (source.getPassword() != null) target.setPassword(source.getPassword());
        if (source.getRole() != null) target.setRole(source.getRole());
    }



    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("Administrator not found with ID: " + id);
        }
        userRepository.deleteById(id);
    }
}
