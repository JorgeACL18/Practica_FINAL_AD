package org.example.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Personaxe {

    @JsonProperty("idpersonaxe")
    private Long idpersonaxe;

    @JsonProperty("nome")
    private String nome;

    @JsonProperty("stand")
    private String stand;

    @JsonProperty("idsaga")
    private Saga idsaga;

    public Personaxe(String nome, String stand) {
        this.nome = nome;
        this.stand = stand;
    }

    public Long getIdpersonaxe() {
        return idpersonaxe;
    }

    public void setIdpersonaxe(Long idpersonaxe) {
        this.idpersonaxe = idpersonaxe;
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

    public Saga getIdsaga() {
        return idsaga;
    }

    public void setIdsaga(Saga idsaga) {
        this.idsaga = idsaga;
    }
}
