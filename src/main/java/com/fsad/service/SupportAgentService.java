package com.fsad.service;

import com.fsad.entity.SupportAgent;

public interface SupportAgentService {
    String supportAgentRegistration(SupportAgent supportAgent);
    SupportAgent supportAgentLogin(String email, String password);
}
