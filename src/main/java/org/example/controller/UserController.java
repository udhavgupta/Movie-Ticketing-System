package org.example.controller;


import org.example.entity.User;
import org.example.reposistory.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            return ResponseEntity.badRequest()
                    .body(Map.of("error", "Email already exists"));
        }

        User savedUser = userRepository.save(user);
        return ResponseEntity.ok(Map.of(
                "message", "User registered successfully",
                "userId", savedUser.getUserId()
        ));
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody Map<String, String> credentials) {
        String email = credentials.get("email");
        String password = credentials.get("password");

        Optional<User> user = userRepository.findByEmailAndPasswordHash(email, password);

        if (user.isPresent()) {
            return ResponseEntity.ok(Map.of(
                    "message", "Login successful",
                    "userId", user.get().getUserId(),
                    "name", user.get().getName()
            ));
        } else {
            return ResponseEntity.badRequest()
                    .body(Map.of("error", "Invalid credentials"));
        }
    }
}
