package com.simple.interest.microservice.domain.entities;

import com.simple.interest.microservice.domain.shared.ValueObject;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public final class CreditRequest implements ValueObject {
    private final Amount amount;
    private final Term term;
    private final Rate rate;

    private CreditRequest(Amount amount, Term term, Rate rate) {
        this.amount = amount;
        this.term = term;
        this.rate = rate;
    }

    public static CreditRequest of(double amount, int term, double rate) {
        return new CreditRequest(Amount.of(amount), Term.of(term), Rate.of(rate));
    }

    public static CreditRequest of(Amount amount, Term term, Rate rate) {
        return new CreditRequest(amount, term, rate);
    }

    public Amount getAmount() {
        return amount;
    }

    public Term getTerm() {
        return term;
    }

    public Rate getRate() {
        return rate;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(amount.getValue())
                .append(term.getValue())
                .append(rate.getValue())
                .toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof CreditRequest creditRequest)) {
            return false;
        }

        return new EqualsBuilder()
                .append(amount, creditRequest.amount)
                .append(term, creditRequest.term)
                .append(rate, creditRequest.rate)
                .isEquals();
    }
}
