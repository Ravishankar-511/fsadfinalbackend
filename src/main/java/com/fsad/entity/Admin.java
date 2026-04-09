package com.fsad.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "admin")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int adminId;

    @Column(nullable = false, unique = true)
    private String adminName;

    @Column(nullable = false, unique = true)
    private String adminEmail;

    @Column(nullable = false)
    private String adminPassword;

    @Column(nullable = false)
    private String adminContact;

    // ===== Constructors =====
    public Admin() {}

    public Admin(int adminId, String adminName, String adminEmail, String adminPassword, String adminContact) {
        this.adminId = adminId;
        this.adminName = adminName;
        this.adminEmail = adminEmail;
        this.adminPassword = adminPassword;
        this.adminContact = adminContact;
    }

    // ===== Getters & Setters =====
    public int getAdminId() { return adminId; }
    public void setAdminId(int adminId) { this.adminId = adminId; }

    public String getAdminName() { return adminName; }
    public void setAdminName(String adminName) { this.adminName = adminName; }

    public String getAdminEmail() { return adminEmail; }
    public void setAdminEmail(String adminEmail) { this.adminEmail = adminEmail; }

    public String getAdminPassword() { return adminPassword; }
    public void setAdminPassword(String adminPassword) { this.adminPassword = adminPassword; }

    public String getAdminContact() { return adminContact; }
    public void setAdminContact(String adminContact) { this.adminContact = adminContact; }

    @Override
    public String toString() {
        return "Admin{adminId=" + adminId + ", adminName='" + adminName + "', adminEmail='" + adminEmail + "'}";
    }
}
