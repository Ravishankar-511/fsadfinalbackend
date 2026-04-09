package com.fsad.service;

import com.fsad.entity.Rating;
import java.util.List;

public interface RatingService {

    Rating saveRating(Rating rating);

    List<Rating> getRatingsForProfessional(String professionalName);

    List<Rating> getRatingsForUser(String userName);
}