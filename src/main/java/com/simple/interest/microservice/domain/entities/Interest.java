package com.simple.interest.microservice.domain.entities;

import java.time.LocalDate;
import java.util.Date;

public record Interest(int paymentNumber, double amount, LocalDate paymentDate) { }