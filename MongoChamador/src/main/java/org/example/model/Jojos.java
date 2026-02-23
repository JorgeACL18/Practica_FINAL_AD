package org.example.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document(collection = "sagas")
public class Jojos {
    @Id
    private String id;
    private List<Saga> sagas;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Saga> getSaga() {
        return sagas;
    }

    public void setSaga(List<Saga> sagas) {
        this.sagas = sagas;
    }
}