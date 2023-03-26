package com.simple.interest.microservice.infrastructure.data.h2;

import com.simple.interest.microservice.infrastructure.data.RequestResponseStorage;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class RequestResponseH2Storage implements RequestResponseStorage {
    private final JdbcTemplate jdbcTemplate;

    public RequestResponseH2Storage(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void save(String request, String response) {
        String sqlQuery = "INSERT INTO data(request, response) VALUES(?, ?)";
        jdbcTemplate.update(sqlQuery, request, response);
    }
}
