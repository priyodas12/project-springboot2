package io.priyolib.projectspringboot2.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

import java.util.UUID;


public class Patient {

    //fields
    private final UUID id;
    private final String name;

    //constructor
    public Patient(@JsonProperty("c_id") UUID id,
                   @JsonProperty("p_name") String name) {
        this.id = id;
        this.name = name;
    }

    //getters
    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
