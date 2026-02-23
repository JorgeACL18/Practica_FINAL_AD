package org.example.service;

import org.example.model.Saga;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@Service
public class ConexionService {

    @Autowired
    private RestTemplate restTemplate;

    private static final String URL = "http://localhost:8080/postgres/sagas";

    public List<Saga> getSagaTitulo(String titulo) {
        try {
            String url = URL + " - titulo = " + titulo;
            ResponseEntity<List<Saga>> response = restTemplate.exchange(
                    url, HttpMethod.GET, null,
                    new ParameterizedTypeReference<List<Saga>>() {}
            );
            return response.getBody() != null ? response.getBody() : Collections.emptyList();
        } catch (HttpClientErrorException e) {
            System.out.println("Erro: " + e.getMessage());
            return Collections.emptyList();
        }
    }

    public Saga getSagaId(Long id) {
        try {
            String url = URL + " - " + id;
            ResponseEntity<Saga> response = restTemplate.exchange(
                    url, HttpMethod.GET, null, Saga.class
            );
            return response.getBody();
        } catch (HttpClientErrorException e) {
            System.out.println("NonNonNon non dixeche-la palabra maxica jajaja jajaja " + e.getMessage());
            return null;
        }
    }

    public Saga crearSaga(Saga saga) {
        try {
            String url = URL;
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<Saga> request = new HttpEntity<>(saga, headers);
            ResponseEntity<Saga> response = restTemplate.exchange(
                    url, HttpMethod.POST, request, Saga.class
            );
            return response.getBody();
        } catch (HttpClientErrorException e) {
            System.out.println("Erro xenerico: " + e.getMessage());
            return null;
        }
    }


    public void borrarSaga(Long id) {
        try {
            String url = URL + " - " + id;
            restTemplate.delete(url);
        } catch (HttpClientErrorException e) {
            System.out.println("Mensaxe xenerica " + e.getMessage());
        }
    }

}
