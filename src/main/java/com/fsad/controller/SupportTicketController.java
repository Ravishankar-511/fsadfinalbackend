package com.fsad.controller;

import com.fsad.entity.SupportTicket;
import com.fsad.service.SupportTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/support")
@CrossOrigin(origins = "http://localhost:5173")
public class SupportTicketController {

    @Autowired
    private SupportTicketService service;

    @PostMapping
    public SupportTicket createTicket(@RequestBody SupportTicket ticket) {
        return service.createTicket(ticket);
    }

    @GetMapping
    public List<SupportTicket> getAllTickets() {
        return service.getAllTickets();
    }
}