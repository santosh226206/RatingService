package com.layp.RatingService.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.layp.RatingService.entities.Rating;

import java.util.List;

public interface RatingService {
    // save Rating
    public Rating saveRating(Rating Rating);
    // get Rating from id
    public Rating getRatingById(String id);
    // get all Rating
    public List<Rating> getAllRating();
    // TODO: update Rating
    public Rating updateRating(String id, JsonNode Rating);
    // TODO: delete Rating
    public void deleteRating(String RatingId);

    // get Rating of particular User
    public List<Rating> getRatingByUserId(String userId);

    // get Rating of particular hotel

    public  List<Rating> getRatingByHotelId(String hotelId);

}
