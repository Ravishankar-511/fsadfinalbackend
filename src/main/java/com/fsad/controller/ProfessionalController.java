package com.fsad.controller;

import com.fsad.entity.Professional;
import com.fsad.service.ProfessionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/professionalapi")
@CrossOrigin(origins = {"http://localhost:5173", "http://localhost:3000"})
public class ProfessionalController {

    @Autowired
    private ProfessionalService professionalService;

    // POST /professionalapi/registration
    @PostMapping("/registration")
    public ResponseEntity<Map<String, String>> professionalRegistration(@RequestBody Professional professional) {
        String message = professionalService.professionalRegistration(professional);
        Map<String, String> response = new HashMap<>();
        response.put("message", message);
        if (message.contains("Successful")) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.badRequest().body(response);
        }
    }

    // POST /professionalapi/login
    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> professionalLogin(@RequestBody Map<String, String> credentials) {
        String email = credentials.get("professionalEmail");
        String password = credentials.get("professionalPassword");

        Professional professional = professionalService.professionalLogin(email, password);
        Map<String, Object> response = new HashMap<>();

        if (professional != null) {
            response.put("message", "Login Successful");
            response.put("role", "professional");
            response.put("professionalId", professional.getProfessionalId());
            response.put("professionalName", professional.getProfessionalName());
            response.put("professionalEmail", professional.getProfessionalEmail());
            response.put("professionalCategory", professional.getProfessionalCategory());
            return ResponseEntity.ok(response);
        } else {
            response.put("message", "Invalid email or password!");
            return ResponseEntity.status(401).body(response);
        }
    }
}
