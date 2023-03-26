package com.simple.interest.microservice;

import com.simple.interest.microservice.application.credits.SimpleInterestCalculator;
import com.simple.interest.microservice.domain.entities.CreditRequest;
import com.simple.interest.microservice.domain.entities.Interest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.*;

public class InterestCalculatorUnitTest {
    private final LocalDate paymentDate = LocalDate.now();
    private SimpleInterestCalculator service;

    @BeforeEach
    void setUp() {
        service = new SimpleInterestCalculator();
    }

    @Test
    void shouldGenerate_thenReturnInterests() {
        // given
        CreditRequest creditRequest = CreditRequest.of(1_000, 4, 10);

        // when
        Interest[] interests = service.Generate(creditRequest);

        // then
        assertThat(interests).hasSize(4);
        assertThat(interests).isEqualTo(interestsExpected());
    }

    private Interest[] interestsExpected() {
        Interest[] interests = new Interest[4];
        interests[0] = new Interest(1, 275, paymentDate.plusWeeks(1));
        interests[1] = new Interest(2, 268.75,  paymentDate.plusWeeks(2));
        interests[2] = new Interest(3, 262.50,  paymentDate.plusWeeks(3));
        interests[3] = new Interest(4, 256.25,  paymentDate.plusWeeks(4));

        return interests;
    }
}
