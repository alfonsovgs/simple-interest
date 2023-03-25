package com.simple.interest.microservice.domain.exceptions;

public class DomainException extends RuntimeException{
    public DomainException(String message) {
        super(message);
    }
}
