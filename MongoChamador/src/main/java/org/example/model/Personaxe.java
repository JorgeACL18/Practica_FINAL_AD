package org.example.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Personaxe {
    @JsonProperty("idpersonaxe")
    private Long idPersonaxe;
    @JsonProperty("nome")
    private String nome;
    @JsonProperty("stand")
    private String stand;

    public Long getIdPersonaxe() {
        return idPersonaxe;
    }
    public void setIdPersonaxe(Long idPersonaxe) {
        this.idPersonaxe = idPersonaxe;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getStand() {
        return stand;
    }
    public void setStand(String stand) {
        this.stand = stand;
    }
}
