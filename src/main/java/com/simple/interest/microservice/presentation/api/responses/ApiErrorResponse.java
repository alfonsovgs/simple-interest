package com.simple.interest.microservice.presentation.api.responses;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class ApiErrorResponse {
    public LocalDateTime timestamp;
    public HttpStatus status;
    public String message;
    public Map<String, String> details;

    private ApiErrorResponse() {
        timestamp = LocalDateTime.now();
        details = new HashMap<>();
    }

    private ApiErrorResponse(HttpStatus status, String message, Map<String, String> details) {
        this();
        this.status = status;
        this.message = message;
        this.details = details;
    }

    public static ApiErrorResponse of(HttpStatus status, String message) {
        return new ApiErrorResponse(status, message, new HashMap<>());
    }

    public static ApiErrorResponse of(HttpStatus status, String message, Map<String, String> details) {
        return new ApiErrorResponse(status, message, details);
    }
}
