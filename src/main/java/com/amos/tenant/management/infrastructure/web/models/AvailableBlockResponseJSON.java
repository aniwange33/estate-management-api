package com.amos.tenant.management.infrastructure.web.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class AvailableBlockResponseJSON {
    private Long id;
    private  String name;
    private  Long numberOfFlats;
    //private AvailableEstateReponseJSON estate;

    @JsonIgnore
    public AvailableBlockResponseJSON(Long id, String name, Long numberofflat) {
        this.id = id;
        this.name = name;
        this.numberOfFlats = numberofflat;
    }
}
