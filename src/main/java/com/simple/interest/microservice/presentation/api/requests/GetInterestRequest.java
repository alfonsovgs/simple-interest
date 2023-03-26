package com.simple.interest.microservice.presentation.api.requests;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

public class GetInterestRequest {
    @Min(value = 2, message = "Amount should be more than 1.")
    @Max(value = 999_998, message = "Amount should be lesser than 999,999.00")
    private final double amount;

    @Min(value = 4, message = "Terms min value should be 4.")
    @Max(value = 52, message = "Terms max value should be 52.")
    private final int terms;

    @Min(value = 2, message = "Rate min value should be more than 1.")
    @Max(value = 99, message = "Rate max value should be lesser than 100.")
    private final double rate;

    @JsonCreator
    public GetInterestRequest(@JsonProperty("amount") final double amount, @JsonProperty("terms") final int terms,
                              @JsonProperty("rate") final double rate) {
        this.amount = amount;
        this.terms = terms;
        this.rate = rate;
    }

    public double getAmount() {
        return amount;
    }

    public int getTerms() {
        return terms;
    }

    public double getRate() {
        return rate;
    }
}
