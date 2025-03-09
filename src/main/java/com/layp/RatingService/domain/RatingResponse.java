package com.layp.RatingService.domain;

import org.springframework.http.HttpStatus;


public class RatingResponse {
    private String message;  // Corrected field name
    private boolean success;
    private HttpStatus status;

    public RatingResponse(boolean success, HttpStatus status, String message) {
        this.success = success;
        this.status = status;
        this.message = message;
    }

    public RatingResponse() {
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
