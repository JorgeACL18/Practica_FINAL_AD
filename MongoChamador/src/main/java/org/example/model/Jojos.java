package org.example.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document(collection = "sagas")
public class Jojos {
    @Id
    private String id;
    private List<Saga> saga;

    public Jojos() {}

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public List<Saga> getSaga() { return saga; }
    public void setSaga(List<Jojos> saga) { this.saga = saga; }
}