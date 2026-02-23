package org.example.service;

import org.example.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@Service
public class JoJosGresService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${jojosgres.url}")
    private String baseUrl;

    private static final String SAGAS_PATH = "/postgres/sagas";

    public Saga crearSaga(Saga saga) {
        try {
            String url = baseUrl + SAGAS_PATH;
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<Saga> request = new HttpEntity<>(saga, headers);
            ResponseEntity<Saga> response = restTemplate.exchange(
                    url, HttpMethod.POST, request, Saga.class);
            return response.getBody();
        } catch (HttpClientErrorException e) {
            System.err.println("Error al crear la saga (JOJOSGRES): " + e.getMessage());
            return null;
        }
    }

    public Saga getSagaById(Long id) {
        try {
            String url = baseUrl + SAGAS_PATH + "/" + id;
            ResponseEntity<Saga> response = restTemplate.exchange(
                    url, HttpMethod.GET, null, Saga.class);
            return response.getBody();
        } catch (HttpClientErrorException e) {
            System.err.println("Error al obtener la saga por ID (JOJOSGRES): " + e.getMessage());
            return null;
        }
    }

    public List<Saga> getSagaByTitulo(String titulo) {
        try {
            String url = baseUrl + SAGAS_PATH + "/titulo/" + titulo;
            ResponseEntity<List<Saga>> response = restTemplate.exchange(
                    url, HttpMethod.GET, null,
                    new ParameterizedTypeReference<List<Saga>>() {});
            return response.getBody() != null ? response.getBody() : Collections.emptyList();
        } catch (HttpClientErrorException e) {
            System.err.println("Error al obtener la saga por título (JOJOSGRES): " + e.getMessage());
            return Collections.emptyList();
        }
    }

    public List<Saga> getAllSagas() {
        try {
            String url = baseUrl + SAGAS_PATH;
            ResponseEntity<List<Saga>> response = restTemplate.exchange(
                    url, HttpMethod.GET, null,
                    new ParameterizedTypeReference<List<Saga>>() {});
            return response.getBody();
        } catch (HttpClientErrorException e) {
            System.err.println("Error al obtener todas las sagas (JOJOSGRES): " + e.getMessage());
            return null;
        }
    }

    public void deleteSaga(Long id) {
        try {
            String url = baseUrl + SAGAS_PATH + "/" + id;
            restTemplate.delete(url);
        } catch (HttpClientErrorException e) {
            System.err.println("Error al borrar la saga (JOJOSGRES): " + e.getMessage());
        }
    }
}