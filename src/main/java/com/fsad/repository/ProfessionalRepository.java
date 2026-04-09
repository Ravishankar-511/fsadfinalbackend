package com.fsad.repository;

import com.fsad.entity.Professional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessionalRepository extends JpaRepository<Professional, Integer> {

    @Query("SELECT p FROM Professional p WHERE p.professionalEmail = :email AND p.professionalPassword = :password")
    Professional checkLogin(@Param("email") String email, @Param("password") String password);

    Professional findByProfessionalEmail(String professionalEmail);
}
