package com.fsad.repository;

import com.fsad.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {

    @Query("SELECT a FROM Admin a WHERE a.adminEmail = :email AND a.adminPassword = :password")
    Admin checkLogin(@Param("email") String email, @Param("password") String password);

    Admin findByAdminEmail(String adminEmail);
}
