package com.fsad.controller;

import com.fsad.entity.Rating;
import com.fsad.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ratings")
@CrossOrigin(origins = "http://localhost:5173")
public class RatingController {

    @Autowired
    private RatingService service;

    @PostMapping
    public Rating saveRating(@RequestBody Rating rating) {
        return service.saveRating(rating);
    }

    @GetMapping("/professional/{name}")
    public List<Rating> getRatingsForProfessional(@PathVariable String name) {
        return service.getRatingsForProfessional(name);
    }

    @GetMapping("/user/{name}")
    public List<Rating> getRatingsForUser(@PathVariable String name) {
        return service.getRatingsForUser(name);
    }
}