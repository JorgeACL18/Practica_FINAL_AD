package org.example.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Saga {

    @JsonProperty("idsaga")
    private Long idsaga;

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

    @JsonProperty("id")
    private String id;

    public Long getIdsaga() {
        return idsaga;
    }

    public void setIdsaga(Long idsaga) {
        this.idsaga = idsaga;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
