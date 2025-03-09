package com.layp.RatingService.exception;

//import com.layp.userService.domain.UserResponse;
import com.layp.RatingService.domain.RatingResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalResponseHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<RatingResponse> handlerResourceNotFound(ResourceNotFoundException resourceNotFoundException){
        String message = resourceNotFoundException.getMessage();

        // Create a HotelResponse using getters and setters
        RatingResponse ratingResponse = new RatingResponse();
        ratingResponse.setMessage(message);
        ratingResponse.setSuccess(true);
        ratingResponse.setStatus(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(ratingResponse, HttpStatus.NOT_FOUND);
    }
}
