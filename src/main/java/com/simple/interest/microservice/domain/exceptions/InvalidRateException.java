package com.simple.interest.microservice.domain.exceptions;

public class InvalidRateException extends DomainException {
    public InvalidRateException() {
        super("Rate should be bigger than 1% and lesser than 100%.");
    }
}
