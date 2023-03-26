package com.simple.interest.microservice.presentation.api.controllers;

import com.simple.interest.microservice.domain.entities.CreditRequest;
import com.simple.interest.microservice.domain.entities.Interest;
import com.simple.interest.microservice.domain.services.InterestCalculator;
import com.simple.interest.microservice.presentation.api.requests.GetInterestRequest;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/interests")
public class InterestController {
    private final InterestCalculator interestCalculator;

    public InterestController(InterestCalculator interestCalculator) {
        this.interestCalculator = interestCalculator;
    }

    @PostMapping(value = "/calculate", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Interest[]> calculate(@Valid @RequestBody final GetInterestRequest request) {
        CreditRequest creditRequest = CreditRequest.of(request.getAmount(), request.getTerms(), request.getRate());
        Interest[] interests = interestCalculator.Generate(creditRequest);

        return ResponseEntity.ok(interests);
    }
}