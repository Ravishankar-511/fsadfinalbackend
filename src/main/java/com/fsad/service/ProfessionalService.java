package com.fsad.service;

import com.fsad.entity.Professional;

public interface ProfessionalService {
    String professionalRegistration(Professional professional);
    Professional professionalLogin(String email, String password);
}
