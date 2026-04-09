package com.fsad.service;

import com.fsad.entity.Rating;
import com.fsad.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepository repository;

    @Override
    public Rating saveRating(Rating rating) {
        return repository.save(rating);
    }

    @Override
    public List<Rating> getRatingsForProfessional(String professionalName) {
        return repository.findByProfessionalName(professionalName);
    }

    @Override
    public List<Rating> getRatingsForUser(String userName) {
        return repository.findByUserName(userName);
    }
}