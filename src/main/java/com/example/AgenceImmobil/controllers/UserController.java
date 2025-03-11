package com.example.AgenceImmobil.controllers;

import com.example.AgenceImmobil.entities.User;
import com.example.AgenceImmobil.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity <List<User>> getUsers(){
        List<User> users = userService.getUsers();
        System.out.println("✅ UserController : getUsers "+users);

        return users.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(users);
    }
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        System.out.println("debug request ++++++++Add User++++++++++++++++++++++++++++++++++++");
        User createdUser = userService.createUser(user);

        return ResponseEntity.status(201).body(createdUser);

    }
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return userService.getUserById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable String email){
        return userService.getUserByEmail(email)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateAdmin(@PathVariable Long id, @RequestBody User updatedUser) {
        try {
            User user = userService.updateUser(id, updatedUser);
            return ResponseEntity.ok(user); // 200 OK
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdmin(@PathVariable Long id) {
        try {
            userService.deleteUser(id);
            return ResponseEntity.noContent().build(); 
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
