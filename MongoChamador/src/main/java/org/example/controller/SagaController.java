package org.example.controller;

import org.bson.Document;
import org.example.model.*;
import org.example.service.SagaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mongonator")
public class SagaController {

    @Autowired
    private SagaService sagaService;

    @PostMapping("/saga")
    public ResponseEntity<Saga> guardarSaga(@RequestBody Saga saga) {
        Saga guardada = sagaService.guardarSaga(saga);
        return ResponseEntity.ok(guardada);
    }

    @GetMapping("/saga")
    public ResponseEntity<List<Saga>> listarSagas() {
        return ResponseEntity.ok(sagaService.listarSaga());
    }

    @GetMapping("/saga/{id}")
    public ResponseEntity<Saga> obtenerSaga(@PathVariable String id) {
        Saga saga = sagaService.obtenerSagaId(id);
        return saga != null ? ResponseEntity.ok(saga) : ResponseEntity.notFound().build();
    }

    @PostMapping("/jojos")
    public ResponseEntity<Jojos> guardarJojos(@RequestBody List<Jojos> saga) {
        Jojos jojos = sagaService.guardarJojos(saga);
        return ResponseEntity.ok(jojos);
    }

    @GetMapping("/jojos")
    public ResponseEntity<Jojos> obtenerJojos() {
        Jojos jojos = sagaService.obtenerJojos();
        return jojos != null ? ResponseEntity.ok(jojos) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/saga")
    public ResponseEntity<Void> borrarTodo() {
        sagaService.borrarTodo();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/all")
    public ResponseEntity<List<Document>> obtenerTodos() {
        List<Document> documentos = sagaService.obtenerTodosDocumento();
        return ResponseEntity.ok(documentos);
    }
}