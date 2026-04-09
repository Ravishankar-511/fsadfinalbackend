package com.fsad.controller;

import com.fsad.entity.SupportAgent;
import com.fsad.service.SupportAgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/supportapi")
@CrossOrigin(origins = {"http://localhost:5173", "http://localhost:3000"})
public class SupportAgentController {

    @Autowired
    private SupportAgentService supportAgentService;

    // POST /supportapi/registration
    @PostMapping("/registration")
    public ResponseEntity<Map<String, String>> supportRegistration(@RequestBody SupportAgent supportAgent) {
        String message = supportAgentService.supportAgentRegistration(supportAgent);
        Map<String, String> response = new HashMap<>();
        response.put("message", message);
        if (message.contains("Successful")) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.badRequest().body(response);
        }
    }

    // POST /supportapi/login
    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> supportLogin(@RequestBody Map<String, String> credentials) {
        String email = credentials.get("supportEmail");
        String password = credentials.get("supportPassword");

        SupportAgent support = supportAgentService.supportAgentLogin(email, password);
        Map<String, Object> response = new HashMap<>();

        if (support != null) {
            response.put("message", "Login Successful");
            response.put("role", "support");
            response.put("supportId", support.getSupportId());
            response.put("supportName", support.getSupportName());
            response.put("supportEmail", support.getSupportEmail());
            return ResponseEntity.ok(response);
        } else {
            response.put("message", "Invalid email or password!");
            return ResponseEntity.status(401).body(response);
        }
    }
}
