package com.simple.interest.microservice.presentation.api.healths;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@Component("Database")
public class DatabaseHealthContributor implements HealthIndicator {
    private final DataSource ds;

    public DatabaseHealthContributor(DataSource ds) {
        this.ds = ds;
    }

    @Override
    public Health health() {
        try (Connection conn = ds.getConnection()) {
            Statement stmt = conn.createStatement();
            stmt.execute("select * from data");
        } catch (SQLException ex) {
            return Health.outOfService().withException(ex).build();
        }
        return Health.up().build();
    }
}
