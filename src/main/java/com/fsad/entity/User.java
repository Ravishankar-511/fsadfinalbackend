package com.fsad.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false, unique = true)
    private String userEmail;

    @Column(nullable = false)
    private String userPassword;

    @Column(nullable = false)
    private String userContact;

    @Column
    private String userAddress;

    // ===== Constructors =====
    public User() {}

    public User(int userId, String userName, String userEmail, String userPassword, String userContact, String userAddress) {
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userContact = userContact;
        this.userAddress = userAddress;
    }

    // ===== Getters & Setters =====
    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }

    public String getUserEmail() { return userEmail; }
    public void setUserEmail(String userEmail) { this.userEmail = userEmail; }

    public String getUserPassword() { return userPassword; }
    public void setUserPassword(String userPassword) { this.userPassword = userPassword; }

    public String getUserContact() { return userContact; }
    public void setUserContact(String userContact) { this.userContact = userContact; }

    public String getUserAddress() { return userAddress; }
    public void setUserAddress(String userAddress) { this.userAddress = userAddress; }

    @Override
    public String toString() {
        return "User{userId=" + userId + ", userName='" + userName + "', userEmail='" + userEmail + "'}";
    }
}
