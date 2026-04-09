package com.fsad.service;

import com.fsad.entity.SupportAgent;
import com.fsad.repository.SupportAgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupportAgentServiceImpl implements SupportAgentService {

    @Autowired
    private SupportAgentRepository supportAgentRepository;

    @Override
    public String supportAgentRegistration(SupportAgent supportAgent) {
        // Check if email already exists
        SupportAgent existing = supportAgentRepository.findBySupportEmail(supportAgent.getSupportEmail());
        if (existing != null) {
            return "Email already registered!";
        }
        supportAgentRepository.save(supportAgent);
        return "Support Agent Registration Successful!";
    }

    @Override
    public SupportAgent supportAgentLogin(String email, String password) {
        return supportAgentRepository.checkLogin(email, password);
    }
}
