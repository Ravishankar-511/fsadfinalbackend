package com.fsad.repository;

import com.fsad.entity.SupportAgent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SupportAgentRepository extends JpaRepository<SupportAgent, Integer> {

    @Query("SELECT s FROM SupportAgent s WHERE s.supportEmail = :email AND s.supportPassword = :password")
    SupportAgent checkLogin(@Param("email") String email, @Param("password") String password);

    SupportAgent findBySupportEmail(String supportEmail);
}
