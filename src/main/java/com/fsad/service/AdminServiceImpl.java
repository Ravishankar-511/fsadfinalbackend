package com.fsad.service;

import com.fsad.entity.Admin;
import com.fsad.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public String adminRegistration(Admin admin) {
        // Check if email already exists
        Admin existing = adminRepository.findByAdminEmail(admin.getAdminEmail());
        if (existing != null) {
            return "Email already registered!";
        }
        adminRepository.save(admin);
        return "Admin Registration Successful!";
    }

    @Override
    public Admin adminLogin(String email, String password) {
        return adminRepository.checkLogin(email, password);
    }
}
