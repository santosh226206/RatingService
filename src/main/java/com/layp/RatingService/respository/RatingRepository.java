package com.layp.RatingService.respository;

import com.layp.RatingService.entities.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RatingRepository extends JpaRepository<Rating,String> {
    Optional<List<Rating>> findByHotelId(String hotelId);
    Optional<List<Rating>> findByUserId(String userId);
}
