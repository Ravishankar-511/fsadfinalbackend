package com.fsad.repository;

import com.fsad.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("SELECT u FROM User u WHERE u.userEmail = :email AND u.userPassword = :password")
    User checkLogin(@Param("email") String email, @Param("password") String password);

    User findByUserEmail(String userEmail);
}
