package com.simple.interest.microservice.domain.entities;

import java.util.Date;

public record Interest(int paymentNumber, double amount, Date paymentDate) { }