package com.simple.interest.microservice.domain.exceptions;

public class InvalidTermsException extends DomainException {
    public InvalidTermsException(int min, int max) {
        super(String.format("Terms should be between %d and %d.", min, max));
    }
}

