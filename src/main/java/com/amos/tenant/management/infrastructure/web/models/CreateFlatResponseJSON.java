package com.amos.tenant.management.infrastructure.web.models;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CreateFlatResponseJSON {
    LocalDate createdDate;
    long id;
    String name;

    public CreateFlatResponseJSON(LocalDate createdDate, long id, String name) {
        this.createdDate = createdDate;
        this.id = id;
        this.name = name;
    }
}
