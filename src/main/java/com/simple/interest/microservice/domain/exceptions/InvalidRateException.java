package com.simple.interest.microservice.domain.exceptions;

public class InvalidRateException extends DomainException {
    public InvalidRateException(double min, double max) {
        super(String.format("Rate should be bigger than %f%% and lesser than %f%%.", min, max));
    }
}
