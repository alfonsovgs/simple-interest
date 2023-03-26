package com.simple.interest.microservice.domain.exceptions;

public class InvalidAmountException extends DomainException {
    public InvalidAmountException(double min, double max) {
        super(String.format("Amount should be more than $%.2f and lesser than $%.2f.", min, max));
    }
}


