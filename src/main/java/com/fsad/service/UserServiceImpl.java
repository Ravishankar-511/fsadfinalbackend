package com.fsad.service;

import com.fsad.entity.User;
import com.fsad.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public String userRegistration(User user) {
        // Check if email already exists
        User existing = userRepository.findByUserEmail(user.getUserEmail());
        if (existing != null) {
            return "Email already registered!";
        }
        userRepository.save(user);
        return "User Registration Successful!";
    }

    @Override
    public User userLogin(String email, String password) {
        return userRepository.checkLogin(email, password);
    }
}
