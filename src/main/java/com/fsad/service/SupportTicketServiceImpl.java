package com.fsad.service;

import com.fsad.entity.SupportTicket;
import com.fsad.repository.SupportTicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupportTicketServiceImpl implements SupportTicketService {

    @Autowired
    private SupportTicketRepository repository;

    @Override
    public SupportTicket createTicket(SupportTicket ticket) {
        return repository.save(ticket);
    }

    @Override
    public List<SupportTicket> getAllTickets() {
        return repository.findAll();
    }
}