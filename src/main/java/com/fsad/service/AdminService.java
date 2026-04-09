package com.fsad.service;

import com.fsad.entity.Admin;

public interface AdminService {
    String adminRegistration(Admin admin);
    Admin adminLogin(String email, String password);
}
