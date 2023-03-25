package com.simple.interest.microservice.domain.services;

import com.simple.interest.microservice.domain.entities.CreditRequest;
import com.simple.interest.microservice.domain.entities.Interest;

public interface InterestCalculator {
    Interest[] Generate(CreditRequest creditRequest);
}
