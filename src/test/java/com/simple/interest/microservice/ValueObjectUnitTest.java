package com.simple.interest.microservice;

import com.simple.interest.microservice.domain.entities.Amount;
import com.simple.interest.microservice.domain.entities.CreditRequest;
import com.simple.interest.microservice.domain.entities.Rate;
import com.simple.interest.microservice.domain.entities.Term;
import com.simple.interest.microservice.domain.exceptions.InvalidAmountException;
import com.simple.interest.microservice.domain.exceptions.InvalidRateException;
import com.simple.interest.microservice.domain.exceptions.InvalidTermsException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class ValueObjectUnitTest {
    @DisplayName("Given a two amount with equal values, then both amounts are equals")
    @Test
    void test0() {
        // given
        Amount amount1 = Amount.of(10);
        Amount amount2 = Amount.of(10);

        // then
        assertThat(amount1).isEqualTo(amount2);
    }

    @DisplayName("Given a two amount with different values, then both amounts are not equals")
    @Test
    void test1() {
        // given
        Amount amount1 = Amount.of(10);
        Amount amount2 = Amount.of(12);

        // then
        assertThat(amount1).isNotEqualTo(amount2);
    }

    @DisplayName("When create an amount with min value, then exception is thrown")
    @Test
    void test2() {
        // when
        Throwable throwable = catchThrowable(() -> Amount.of(1));

        // then
        assertThat(throwable).isInstanceOf(InvalidAmountException.class);
    }

    @DisplayName("When create an amount with max value, then exception is thrown")
    @Test
    void test3() {
        // when
        Throwable throwable = catchThrowable(() -> Amount.of(999_999.1));

        // then
        assertThat(throwable).isInstanceOf(InvalidAmountException.class);
    }

    @DisplayName("Given a two terms with equal values, then both terms are equals")
    @Test
    void test4() {
        // given
        Term term1 = Term.of(10);
        Term term2 = Term.of(10);

        // then
        assertThat(term1).isEqualTo(term2);
    }

    @DisplayName("Given a two terms with different values, then both terms are not equals")
    @Test
    void test5() {
        // given
        Term term1 = Term.of(10);
        Term term2 = Term.of(12);

        // then
        assertThat(term1).isNotEqualTo(term2);
    }

    @DisplayName("When create a term with min value, then exception is thrown")
    @Test
    void test6() {
        // when
        Throwable throwable = catchThrowable(() -> Term.of(3));

        // then
        assertThat(throwable).isInstanceOf(InvalidTermsException.class);
    }

    @DisplayName("When create a term with max value, then exception is thrown")
    @Test
    void test7() {
        // when
        Throwable throwable = catchThrowable(() -> Term.of(100));

        // then
        assertThat(throwable).isInstanceOf(InvalidTermsException.class);
    }

    @DisplayName("Given a two rates with equal values, then both rates are equals")
    @Test
    void test8() {
        // given
        Rate rate1 = Rate.of(10);
        Rate rate2 = Rate.of(10);

        // then
        assertThat(rate1).isEqualTo(rate2);
    }

    @DisplayName("Given a two rates with different values, then both rates are not equals")
    @Test
    void test9() {
        // given
        Rate rate1 = Rate.of(10);
        Rate rate2 = Rate.of(12);

        // then
        assertThat(rate1).isNotEqualTo(rate2);
    }

    @DisplayName("When create a rate with min value, then exception is thrown")
    @Test
    void test10() {
        // when
        Throwable throwable = catchThrowable(() -> Rate.of(1));

        // then
        assertThat(throwable).isInstanceOf(InvalidRateException.class);
    }

    @DisplayName("When create a term with max value, then exception is thrown")
    @Test
    void test11() {
        // when
        Throwable throwable = catchThrowable(() -> Rate.of(100));

        // then
        assertThat(throwable).isInstanceOf(InvalidRateException.class);
    }

    @DisplayName("Given a two creditRequest with equal values, then both creditRequest are equals")
    @Test
    void test12() {
        // given
        CreditRequest creditRequest1 = CreditRequest.of(Amount.of(1_000), Term.of(4), Rate.of(24));
        CreditRequest creditRequest2 = CreditRequest.of(Amount.of(1_000), Term.of(4), Rate.of(24));

        // then
        assertThat(creditRequest1).isEqualTo(creditRequest2);
    }
    @DisplayName("Given a two creditRequest with different values, then both creditRequest are not equals")
    @Test
    void test13() {
        // given
        CreditRequest creditRequest1 = CreditRequest.of(Amount.of(1_000), Term.of(4), Rate.of(24));
        CreditRequest creditRequest2 = CreditRequest.of(Amount.of(1_000), Term.of(4), Rate.of(25));

        // then
        assertThat(creditRequest1).isNotEqualTo(creditRequest2);
    }
}
