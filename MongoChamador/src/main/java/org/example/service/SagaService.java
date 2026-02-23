package org.example.service;

import org.bson.Document;
import org.example.model.*;
import org.example.repository.SagaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SagaService {

    @Autowired
    private SagaRepository sagaRepo;

    @Autowired
    private MongoTemplate mongoTemplate;

    public Saga guardarSaga(Saga saga) {
        saga.setId(null);
        return sagaRepo.save(saga);
    }

    public List<Saga> listarSaga() {
        return sagaRepo.findAll();
    }

    public Saga obtenerSagaId(String id) {
        return sagaRepo.findById(id).orElse(null);
    }

    public Jojos guardarJojos (List<Jojos> saga) {
        Jojos jojos = new Jojos();
        jojos.setId("Jojos");
        jojos.setSaga(saga);
        return mongoTemplate.save(jojos, "sagas");
    }

    public Jojos obtenerJojos() {
        return mongoTemplate.findById("Jojos", Jojos.class, "saga");
    }

    public void borrarTodo() {
        sagaRepo.deleteAll();
    }

    public List<Document> obtenerTodosDocumento() {
        return mongoTemplate.findAll(Document.class, "saga");
    }
}
