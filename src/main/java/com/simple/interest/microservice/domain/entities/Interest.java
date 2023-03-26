package com.simple.interest.microservice.domain.entities;

import java.time.LocalDate;

public record Interest(int paymentNumber, double amount, LocalDate paymentDate) {
}