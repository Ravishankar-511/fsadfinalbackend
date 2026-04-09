package com.fsad.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "support_agent")
public class SupportAgent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int supportId;

    @Column(nullable = false)
    private String supportName;

    @Column(nullable = false, unique = true)
    private String supportEmail;

    @Column(nullable = false)
    private String supportPassword;

    @Column(nullable = false)
    private String supportContact;

    // ===== Constructors =====
    public SupportAgent() {}

    public SupportAgent(int supportId, String supportName, String supportEmail, String supportPassword, String supportContact) {
        this.supportId = supportId;
        this.supportName = supportName;
        this.supportEmail = supportEmail;
        this.supportPassword = supportPassword;
        this.supportContact = supportContact;
    }

    // ===== Getters & Setters =====
    public int getSupportId() { return supportId; }
    public void setSupportId(int supportId) { this.supportId = supportId; }

    public String getSupportName() { return supportName; }
    public void setSupportName(String supportName) { this.supportName = supportName; }

    public String getSupportEmail() { return supportEmail; }
    public void setSupportEmail(String supportEmail) { this.supportEmail = supportEmail; }

    public String getSupportPassword() { return supportPassword; }
    public void setSupportPassword(String supportPassword) { this.supportPassword = supportPassword; }

    public String getSupportContact() { return supportContact; }
    public void setSupportContact(String supportContact) { this.supportContact = supportContact; }

    @Override
    public String toString() {
        return "SupportAgent{supportId=" + supportId + ", supportName='" + supportName + "', supportEmail='" + supportEmail + "'}";
    }
}
