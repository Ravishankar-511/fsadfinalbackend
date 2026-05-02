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
@CrossOrigin(origins = "https://fsadfinalfrontend.vercel.app")
public class ProfessionalController {

    @Autowired
    private ProfessionalService professionalService;

    @PostMapping("/registration")
    public ResponseEntity<Map<String, String>> professionalRegistration(@RequestBody Professional professional) {
        String message = professionalService.professionalRegistration(professional);
        Map<String, String> response = new HashMap<>();
        response.put("message", message);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> professionalLogin(@RequestBody Map<String, String> credentials) {
        String email = credentials.get("professionalEmail");
        String password = credentials.get("professionalPassword");

        Professional professional = professionalService.professionalLogin(email, password);

        Map<String, Object> response = new HashMap<>();

        if (professional != null) {
            response.put("message", "Login Successful");
            response.put("professionalName", professional.getProfessionalName());
            return ResponseEntity.ok(response);
        } else {
            response.put("message", "Invalid email or password!");
            return ResponseEntity.status(401).body(response);
        }
    }
}