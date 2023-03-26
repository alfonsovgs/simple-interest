package com.simple.interest.microservice.domain.entities;


import com.simple.interest.microservice.domain.exceptions.InvalidTermsException;
import com.simple.interest.microservice.domain.shared.ValueObject;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public final class Term implements ValueObject {
    private static final int MIN_RATE = 4;
    private static final int MAX_RATE = 52;

    private final int value;

    private Term(int value) {
        this.value = value;
    }

    public static Term of(int value) {
        Term rate = new Term(value);
        rate.validate();

        return rate;
    }

    private void validate() {
        if (value < MIN_RATE || value > MAX_RATE) {
            throw new InvalidTermsException(MIN_RATE, MAX_RATE);
        }
    }

    public int getValue() {
        return value;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(value)
                .toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Term term)) {
            return false;
        }

        return value == term.value;
    }
}

