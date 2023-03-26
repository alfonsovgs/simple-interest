package com.simple.interest.microservice.domain.entities;

import com.simple.interest.microservice.domain.exceptions.InvalidRateException;
import com.simple.interest.microservice.domain.shared.ValueObject;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public final class Rate implements ValueObject {
    private static final double MIN_RATE = 1;
    private static final double MAX_RATE = 100;

    private final double value;

    private Rate(double value) {
        this.value = value;
    }

    public static Rate of(double value) {
        Rate rate = new Rate(value);
        rate.validate();

        return rate;
    }

    private void validate() {
        if (value <= MIN_RATE || value >= MAX_RATE) {
            throw new InvalidRateException();
        }
    }

    public double getValue() {
        return value;
    }

    public double getDecimalValue() {
        return value / 100;
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

        if (!(obj instanceof Rate)) {
            return false;
        }

        Rate rate = (Rate) obj;
        return value == rate.value;
    }
}
