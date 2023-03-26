package com.simple.interest.microservice;

import com.simple.interest.microservice.application.credits.SimpleInterestCalculator;
import com.simple.interest.microservice.domain.services.InterestCalculator;
import com.simple.interest.microservice.infrastructure.data.RequestResponseStorage;
import com.simple.interest.microservice.infrastructure.data.h2.RequestResponseH2Storage;
import com.simple.interest.microservice.presentation.api.filters.RequestResponseFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackageClasses = SimpleInterestMicroserviceApplication.class)
public class BeanConfiguration {

    @Bean
    InterestCalculator interestCalculator() {
        return new SimpleInterestCalculator();
    }

    @Bean
    RequestResponseStorage requestResponseStorage(DataSource dataSource) {
        return new RequestResponseH2Storage(dataSource);
    }

    @Bean
    public FilterRegistrationBean<RequestResponseFilter> addRequestResponseFilters(RequestResponseStorage storage) {
        FilterRegistrationBean<RequestResponseFilter> registrationBean = new FilterRegistrationBean<>();

        registrationBean.setFilter(new RequestResponseFilter(storage));
        registrationBean.addUrlPatterns("/api/interests/calculate");

        return registrationBean;
    }
}
