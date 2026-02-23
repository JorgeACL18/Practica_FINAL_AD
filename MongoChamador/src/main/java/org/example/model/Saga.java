package org.example.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "sagas")
public class Saga {
    @Id
    private String id;

    @JsonProperty("idsaga")
    private Long idSaga;

    @JsonProperty("titulo")
    private String titulo;

    @JsonProperty("parte")
    private int parte;

    @JsonProperty("anoinicio")
    private int anoinicio;

    @JsonProperty("ambientacion")
    private String ambientacion;

    @JsonProperty("personaxes")
    private List<Personaxe> personaxes;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getIdSaga() {
        return idSaga;
    }

    public void setIdSaga(Long idSaga) {
        this.idSaga = idSaga;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getParte() {
        return parte;
    }

    public void setParte(int parte) {
        this.parte = parte;
    }

    public int getAnoinicio() {
        return anoinicio;
    }

    public void setAnoinicio(int anoinicio) {
        this.anoinicio = anoinicio;
    }

    public String getAmbientacion() {
        return ambientacion;
    }

    public void setAmbientacion(String ambientacion) {
        this.ambientacion = ambientacion;
    }

    public List<Personaxe> getPersonaxes() {
        return personaxes;
    }

    public void setPersonaxes(List<Personaxe> personaxes) {
        this.personaxes = personaxes;
    }
}
