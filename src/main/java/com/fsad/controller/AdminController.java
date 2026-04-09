package com.fsad.controller;

import com.fsad.entity.Admin;
import com.fsad.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/adminapi")
@CrossOrigin(origins = {"*"})
public class AdminController {

    @Autowired
    private AdminService adminService;

    // POST /adminapi/registration
    @PostMapping("/registration")
    public ResponseEntity<Map<String, String>> adminRegistration(@RequestBody Admin admin) {
        String message = adminService.adminRegistration(admin);
        Map<String, String> response = new HashMap<>();
        response.put("message", message);
        if (message.contains("Successful")) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.badRequest().body(response);
        }
    }

    // POST /adminapi/login
    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> adminLogin(@RequestBody Map<String, String> credentials) {
        String email = credentials.get("adminEmail");
        String password = credentials.get("adminPassword");

        Admin admin = adminService.adminLogin(email, password);
        Map<String, Object> response = new HashMap<>();

        if (admin != null) {
            response.put("message", "Login Successful");
            response.put("role", "admin");
            response.put("adminId", admin.getAdminId());
            response.put("adminName", admin.getAdminName());
            response.put("adminEmail", admin.getAdminEmail());
            return ResponseEntity.ok(response);
        } else {
            response.put("message", "Invalid email or password!");
            return ResponseEntity.status(401).body(response);
        }
    }
}
