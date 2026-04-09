package com.fsad.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "professional")
public class Professional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int professionalId;

    @Column(nullable = false)
    private String professionalName;

    @Column(nullable = false, unique = true)
    private String professionalEmail;

    @Column(nullable = false)
    private String professionalPassword;

    @Column(nullable = false)
    private String professionalContact;

    @Column(nullable = false)
    private String professionalCategory;

    @Column
    private String professionalExperience;

    @Column
    private String professionalLocation;

    // ===== Constructors =====
    public Professional() {}

    public Professional(int professionalId, String professionalName, String professionalEmail,
                        String professionalPassword, String professionalContact,
                        String professionalCategory, String professionalExperience,
                        String professionalLocation) {
        this.professionalId = professionalId;
        this.professionalName = professionalName;
        this.professionalEmail = professionalEmail;
        this.professionalPassword = professionalPassword;
        this.professionalContact = professionalContact;
        this.professionalCategory = professionalCategory;
        this.professionalExperience = professionalExperience;
        this.professionalLocation = professionalLocation;
    }

    // ===== Getters & Setters =====
    public int getProfessionalId() { return professionalId; }
    public void setProfessionalId(int professionalId) { this.professionalId = professionalId; }

    public String getProfessionalName() { return professionalName; }
    public void setProfessionalName(String professionalName) { this.professionalName = professionalName; }

    public String getProfessionalEmail() { return professionalEmail; }
    public void setProfessionalEmail(String professionalEmail) { this.professionalEmail = professionalEmail; }

    public String getProfessionalPassword() { return professionalPassword; }
    public void setProfessionalPassword(String professionalPassword) { this.professionalPassword = professionalPassword; }

    public String getProfessionalContact() { return professionalContact; }
    public void setProfessionalContact(String professionalContact) { this.professionalContact = professionalContact; }

    public String getProfessionalCategory() { return professionalCategory; }
    public void setProfessionalCategory(String professionalCategory) { this.professionalCategory = professionalCategory; }

    public String getProfessionalExperience() { return professionalExperience; }
    public void setProfessionalExperience(String professionalExperience) { this.professionalExperience = professionalExperience; }

    public String getProfessionalLocation() { return professionalLocation; }
    public void setProfessionalLocation(String professionalLocation) { this.professionalLocation = professionalLocation; }

    @Override
    public String toString() {
        return "Professional{professionalId=" + professionalId + ", professionalName='" + professionalName
                + "', professionalEmail='" + professionalEmail + "', category='" + professionalCategory + "'}";
    }
}
