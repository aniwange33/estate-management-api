package com.amos.tenant.management.infrastructure.web.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CreateBlockResponseJSON {
    long id;
    String name;
    LocalDate createdDate;

    @JsonIgnore
    public CreateBlockResponseJSON(long id, String name, LocalDate  createdDate) {
        this.id = id;
        this.name = name;
        this.createdDate=createdDate;
    }
}
