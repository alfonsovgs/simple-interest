package com.simple.interest.microservice.application;

import com.simple.interest.microservice.SimpleInterestMicroserviceApplication;
import com.simple.interest.microservice.application.credits.SimpleInterestCalculator;
import com.simple.interest.microservice.domain.services.InterestCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = SimpleInterestMicroserviceApplication.class)
public class BeanConfiguration {

    @Bean
    InterestCalculator interestCalculator() {
        return new SimpleInterestCalculator();
    }
}
