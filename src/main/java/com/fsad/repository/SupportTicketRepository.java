package com.fsad.repository;

import com.fsad.entity.SupportTicket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupportTicketRepository extends JpaRepository<SupportTicket, Long> {
}