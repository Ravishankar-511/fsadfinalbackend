package com.fsad.controller;

import com.fsad.entity.ServiceRequest;
import com.fsad.service.ServiceRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/requests")
@CrossOrigin(origins = "http://localhost:5173")
public class ServiceRequestController {

    @Autowired
    private ServiceRequestService service;

    @PostMapping
    public ServiceRequest createRequest(@RequestBody ServiceRequest request) {
        return service.createRequest(request);
    }

    @GetMapping("/professional/{name}")
    public List<ServiceRequest> getProfessionalRequests(@PathVariable String name) {
        return service.getRequestsForProfessional(name);
    }

    @GetMapping("/user/{name}")
    public List<ServiceRequest> getUserRequests(@PathVariable String name) {
        return service.getRequestsForUser(name);
    }

    @PutMapping("/{id}")
    public ServiceRequest updateStatus(@PathVariable Long id, @RequestParam String status) {
        return service.updateStatus(id, status);
    }
}