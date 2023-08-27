package com.joaogabriel.dotaApi.dto.hero;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class OpenDotaApi<T> {

    private final RestTemplate restTemplate;

    public OpenDotaApi(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    public T getFromEntity(final String path,final Class<T> clazz ) {
        T response = restTemplate.getForEntity(path,clazz).getBody();
        checkResponse(response);
        return response;
    }

    public List<T> getListFromEntity(final String path, final Class<T[]> clazz) {
        T[] response = restTemplate.getForEntity(path, clazz).getBody();
        checkResponse(response);
        return List.of(response);
    }

    private <T> void checkResponse(T response) {
        if(response == null) {
            throw new RuntimeException("Dota API Exception.");
        }
    }
}
