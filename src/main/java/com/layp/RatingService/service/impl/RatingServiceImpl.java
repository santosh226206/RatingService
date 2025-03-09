package com.layp.RatingService.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.layp.RatingService.entities.Rating;
import com.layp.RatingService.exception.ResourceNotFoundException;
import com.layp.RatingService.respository.RatingRepository;
import com.layp.RatingService.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    RatingRepository ratingRepository;
    @Override
    public Rating saveRating(Rating rating) {
        String uuid= UUID.randomUUID().toString();
        rating.setRatingId(uuid);
        return ratingRepository.save(rating);
    }

    @Override
    public Rating getRatingById(String id) {
        return ratingRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Rating Does Not Esixt"));
    }

    @Override
    public List<Rating> getAllRating() {
        return ratingRepository.findAll();
    }

    @Override
    public Rating updateRating(String id, JsonNode ratingUpdates) {
        Rating existingRating = ratingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Rating not found"));

        // Check and update fields based on the request body (JsonNode)
        if (ratingUpdates.has("Rating") && !ratingUpdates.get("Rating").isNull()) {
            existingRating.setRating(ratingUpdates.get("Rating").asInt());
        }

        if (ratingUpdates.has("feedback") && !ratingUpdates.get("feedback").isNull()) {
            existingRating.setFeedback(ratingUpdates.get("feedback").asText());
        }

        // Save the updated entity (this performs the update)
        return ratingRepository.save(existingRating);
    }

    @Override
    public void deleteRating(String RatingId) {
        ratingRepository.deleteById(RatingId);
    }

    @Override
    public List<Rating> getRatingByUserId(String userId) {
        return ratingRepository.findByUserId(userId).orElseThrow(()->new ResourceNotFoundException("Rating Does Not Esixt"));
    }

    @Override
    public List<Rating> getRatingByHotelId(String hotelId) {
        return ratingRepository.findByHotelId(hotelId).orElseThrow(()->new ResourceNotFoundException("Rating Does Not Esixt"));
    }
}
