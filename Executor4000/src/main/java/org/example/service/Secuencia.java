package org.example.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.bson.Document;
import org.example.model.Personaxe;
import org.example.model.Saga;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class Secuencia {

    @Autowired
    private JoJosGresService jojosGresService;

    @Autowired
    private MongonatorService mongonatorService;

    public void executar() {

        List<Personaxe> personaxes = new ArrayList<>();
        personaxes.add(new Personaxe("Giorno Giovanna", "Gold Experience"));
        personaxes.add(new Personaxe("Bruno Bucciarati", "Sticky Fingers"));
        personaxes.add(new Personaxe("Guido Mista", "Sex Pistols"));

        Saga ventoAureo = new Saga();
        ventoAureo.setTitulo("Vento Aureo");
        ventoAureo.setParte(5);
        ventoAureo.setAmbientacion("Italia");
        ventoAureo.setAnoinicio(2001);
        ventoAureo.setPersonaxes(personaxes);

        Saga ventoCreada = jojosGresService.crearSaga(ventoAureo);
        Long idVentoAureo = ventoCreada != null ? ventoCreada.getIdsaga() : null;

        Saga sagaId2 = jojosGresService.getSagaById(2L);
        if (sagaId2 != null) {
            mongonatorService.guardarSaga(sagaId2);
        } else {
            System.out.println("SAGA CON ID 2 NO ENCONTRADA");
        }

        List<Saga> resultados = jojosGresService.getSagaByTitulo("Stardust Crusaders");
        if (!resultados.isEmpty()) {
            mongonatorService.guardarSaga(resultados.get(0));
        } else {
            System.out.println("SAGA STARDUST NO ENCONTRADA");
        }

        List<Saga> todasAsSagas = jojosGresService.getAllSagas();
        if (todasAsSagas != null) {
            for (Saga saga : todasAsSagas) {
                mongonatorService.guardarSaga(saga);
            }
        }

        if (todasAsSagas != null) {
            mongonatorService.guardarLosJoJos(todasAsSagas);
        }

        List<Document> todosDocumentos = mongonatorService.obtenerTodosLosDocumentos();
        if (todosDocumentos != null) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String archivo = "sagas.json";
            try (FileWriter escritor = new FileWriter(archivo)) {
                gson.toJson(todosDocumentos, escritor);
                System.out.println("JSON EXPORTADO: " + archivo);
            } catch (IOException e) {
                System.err.println("ERROR AL ESCRIBIR ARCHIVO JSON: " + e.getMessage());
            }
        } else {
            System.err.println("NO SE PUDIERON OBTENER DOCUMENTOS DE MONGOCHAMADOR");
        }

        // mongonatorService.borrarTodo();

        if (idVentoAureo != null) {
            jojosGresService.deleteSaga(idVentoAureo);
        } else {
            System.out.println("NO SE PUDO BORRAR VENTO AUREO ID DESCONOCIDO");
        }
    }
}