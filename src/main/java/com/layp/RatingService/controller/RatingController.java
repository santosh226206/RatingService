package com.layp.RatingService.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.layp.RatingService.entities.Rating;
import com.layp.RatingService.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    // Endpoint to create a new rating
    @PostMapping("/addRating")
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating) {
        Rating createdRating = ratingService.saveRating(rating);
        return new ResponseEntity<>(createdRating, HttpStatus.CREATED);
    }

    // Endpoint to get a rating by its ID
    @GetMapping("/getRatingById/{id}")
    public ResponseEntity<Rating> getRatingById(@PathVariable String id) {
        Rating rating = ratingService.getRatingById(id);
        return new ResponseEntity<>(rating, HttpStatus.OK);
    }

    // Endpoint to get all ratings
    @GetMapping("/getAllRating")
    public ResponseEntity<List<Rating>> getAllRatings() {
        List<Rating> ratings = ratingService.getAllRating();
        return new ResponseEntity<>(ratings, HttpStatus.OK);
    }

    // Endpoint to update a rating
    @PutMapping("/updateRating/{id}")
    public ResponseEntity<Rating> updateRating(
            @PathVariable String id, @RequestBody JsonNode ratingUpdates) {
        Rating updatedRating = ratingService.updateRating(id, ratingUpdates);
        return new ResponseEntity<>(updatedRating, HttpStatus.OK);
    }

    // Endpoint to delete a rating by user ID
    @DeleteMapping("/removeRating/{userId}")
    public ResponseEntity<Void> deleteRating(@PathVariable String userId) {
        ratingService.deleteRating(userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Endpoint to get a rating by user ID
    @GetMapping("/rating/user/{userId}")
    public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable String userId) {
        List<Rating> rating = ratingService.getRatingByUserId(userId);
        return new ResponseEntity<>(rating, HttpStatus.OK);
    }

    // Endpoint to get a rating by hotel ID
    @GetMapping("/rating/hotel/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable String hotelId) {
        List<Rating> rating = ratingService.getRatingByHotelId(hotelId);
        return new ResponseEntity<>(rating, HttpStatus.OK);
    }
}
