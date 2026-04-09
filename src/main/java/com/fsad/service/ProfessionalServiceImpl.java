package com.fsad.service;

import com.fsad.entity.Professional;
import com.fsad.repository.ProfessionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfessionalServiceImpl implements ProfessionalService {

    @Autowired
    private ProfessionalRepository professionalRepository;

    @Override
    public String professionalRegistration(Professional professional) {
        // Check if email already exists
        Professional existing = professionalRepository.findByProfessionalEmail(professional.getProfessionalEmail());
        if (existing != null) {
            return "Email already registered!";
        }
        professionalRepository.save(professional);
        return "Professional Registration Successful!";
    }

    @Override
    public Professional professionalLogin(String email, String password) {
        return professionalRepository.checkLogin(email, password);
    }
}
