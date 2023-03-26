package com.simple.interest.microservice.application.credits;

import com.simple.interest.microservice.domain.entities.CreditRequest;
import com.simple.interest.microservice.domain.entities.Interest;
import com.simple.interest.microservice.domain.services.InterestCalculator;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

public class SimpleInterestCalculator implements InterestCalculator {
    private final int WEEKS_TO_ADD = 1;
    
    @Override
    public Interest[] Generate(CreditRequest creditRequest) {
        LocalDate paymentDate = LocalDate.now();

        double initialAmount = creditRequest.getAmount().getValue();
        double rate = creditRequest.getRate().getDecimalValue();
        int terms = creditRequest.getTerm().getValue();

        double amount = initialAmount;
        Interest[] interests = new Interest[terms];
        for(int paymentNumber = 1; paymentNumber <= terms; paymentNumber++) {
            double interestByWeek = amount * rate / terms;
            double amortization = initialAmount / terms;
            double paymentAmount = interestByWeek + amortization;

            paymentDate = paymentDate.plusWeeks(WEEKS_TO_ADD);

            Interest interest = new Interest(paymentNumber, paymentAmount, paymentDate);
            interests[paymentNumber - 1] = interest;

            amount = amount + interestByWeek - paymentAmount;
        }

        return interests;
    }
}
