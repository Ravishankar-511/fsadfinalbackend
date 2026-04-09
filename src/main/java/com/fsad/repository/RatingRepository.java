package com.fsad.repository;

import com.fsad.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating, Long> {

    List<Rating> findByProfessionalName(String professionalName);

    List<Rating> findByUserName(String userName);
}