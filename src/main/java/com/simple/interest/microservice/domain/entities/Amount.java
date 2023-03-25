package com.simple.interest.microservice.domain.entities;

import com.simple.interest.microservice.domain.exceptions.InvalidAmountException;
import com.simple.interest.microservice.domain.shared.ValueObject;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public final class Amount implements ValueObject {
    private static final double MIN_AMOUNT = 1;
    private static final double MAX_AMOUNT = 999_999.00;

    private final double value;

    private Amount(double value) {
        this.value = value;
    }

    public static Amount of(double value) {
        Amount amount = new Amount(value);
        amount.validate();

        return amount;
    }

    private void validate() {
        if(value <= MIN_AMOUNT || value >= MAX_AMOUNT) {
            throw new InvalidAmountException();
        }
    }

    public double getValue() {
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
        if(this == obj){
            return true;
        }

        if (!(obj instanceof Amount)) {
            return false;
        }

        Amount amount = (Amount) obj;
        return value == amount.value;
    }
}

