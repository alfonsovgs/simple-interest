package com.simple.interest.microservice.domain.exceptions;

public class InvalidAmountException extends DomainException {
    public InvalidAmountException() { super("Amount should be more than $1.00 and lesser than $999,999.00."); }
}


