package org.example.controller;

import org.example.model.*;
import org.example.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(RestSagas.MAPPING)
public class RestSagas {
    public static final String MAPPING = "/postgres/sagas";

    @Autowired
    private SagaService sagaService;
    @Autowired
    private PersonaxeService personaxeService;

    @GetMapping
    public ResponseEntity<List<Saga>> getAll(){
        return ResponseEntity.ok(sagaService.findAll());
    }

    @PostMapping
    public ResponseEntity<Saga> create(@RequestBody Saga saga) {
        if(saga.getPersonaxes() != null) {
            saga.getPersonaxes().forEach(a -> a.setSaga(saga));

        }
        return ResponseEntity.ok(sagaService.save(saga));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Saga> getById(@PathVariable Long id) {
        return sagaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/titulo/{titulo}")
    public ResponseEntity<Optional<List<Saga>>> getByTitulo(@PathVariable String titulo) {
        Optional<List<Saga>> sagas = sagaService.findByTitulo(titulo);
        return ResponseEntity.ok(sagas);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        if(!sagaService.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        sagaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
