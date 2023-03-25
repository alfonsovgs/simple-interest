package com.simple.interest.microservice.domain.exceptions;

public class InvalidTermsException extends DomainException {
    public InvalidTermsException() {
        super("Terms should be between 4 and 52.");
    }
}

