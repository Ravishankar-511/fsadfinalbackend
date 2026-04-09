package com.fsad.service;

import com.fsad.entity.SupportTicket;
import java.util.List;

public interface SupportTicketService {
    SupportTicket createTicket(SupportTicket ticket);
    List<SupportTicket> getAllTickets();
}