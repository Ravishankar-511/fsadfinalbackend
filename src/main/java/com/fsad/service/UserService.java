package com.fsad.service;

import com.fsad.entity.User;

public interface UserService {
    String userRegistration(User user);
    User userLogin(String email, String password);
}
