package com.simple.interest.microservice.infrastructure.data;

public interface RequestResponseStorage {
    void save(String request, String response);
}
