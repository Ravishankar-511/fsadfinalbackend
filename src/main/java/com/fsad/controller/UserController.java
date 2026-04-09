package com.fsad.controller;

import com.fsad.entity.User;
import com.fsad.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/userapi")
@CrossOrigin(origins = {"http://localhost:5173", "http://localhost:3000"})
public class UserController {

    @Autowired
    private UserService userService;

    // POST /userapi/registration
    @PostMapping("/registration")
    public ResponseEntity<Map<String, String>> userRegistration(@RequestBody User user) {
        String message = userService.userRegistration(user);
        Map<String, String> response = new HashMap<>();
        response.put("message", message);
        if (message.contains("Successful")) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.badRequest().body(response);
        }
    }

    // POST /userapi/login
    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> userLogin(@RequestBody Map<String, String> credentials) {
        String email = credentials.get("userEmail");
        String password = credentials.get("userPassword");

        User user = userService.userLogin(email, password);
        Map<String, Object> response = new HashMap<>();

        if (user != null) {
            response.put("message", "Login Successful");
            response.put("role", "user");
            response.put("userId", user.getUserId());
            response.put("userName", user.getUserName());
            response.put("userEmail", user.getUserEmail());
            return ResponseEntity.ok(response);
        } else {
            response.put("message", "Invalid email or password!");
            return ResponseEntity.status(401).body(response);
        }
    }
}
