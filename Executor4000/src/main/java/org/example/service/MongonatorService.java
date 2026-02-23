package org.example.service;

import org.bson.Document;
import org.example.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@Service
public class MongonatorService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${mongonator.url}")
    private String baseUrl;

    private static final String SAGAS_PATH = "/mongonator/sagas";
    private static final String LOSJOJOS_PATH = "/mongonator/jojos";
    private static final String ALL_PATH = "/mongonator/all";

    public void guardarSaga(Saga saga) {
        try {
            String url = baseUrl + SAGAS_PATH;
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<Saga> request = new HttpEntity<>(saga, headers);
            restTemplate.exchange(url, HttpMethod.POST, request, Saga.class);
        } catch (HttpClientErrorException e) {
            System.err.println("EERRRROR AL GUARDAR SAGA MONGOCHAMDOR: " + e.getMessage());
        }
    }

    public void guardarLosJoJos(List<Saga> sagas) {
        try {
            String url = baseUrl + LOSJOJOS_PATH;
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<List<Saga>> request = new HttpEntity<>(sagas, headers);
            restTemplate.exchange(url, HttpMethod.POST, request, Void.class);
        } catch (HttpClientErrorException e) {
            System.err.println("ERROR GUARDAR LOSJOJOS MONGOCHAMADORCH: " + e.getMessage());
        }
    }

    public void borrarTodo() {
        try {
            String url = baseUrl + SAGAS_PATH;
            restTemplate.delete(url);
        } catch (HttpClientErrorException e) {
            System.err.println("ERROR AL BORRAR EL MONGOCHAMDOR: " + e.getMessage());
        }
    }

    public List<Document> obtenerTodosLosDocumentos() {
        try {
            String url = baseUrl + ALL_PATH;
            ResponseEntity<List<Document>> response = restTemplate.exchange(
                    url, HttpMethod.GET, null,
                    new ParameterizedTypeReference<List<Document>>() {});
            return response.getBody();
        } catch (HttpClientErrorException e) {
            System.err.println("EERRROR AL OBTENER DOCUMENTOS: " + e.getMessage());
            return null;
        }
    }
}