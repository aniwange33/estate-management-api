package com.amos.tenant.management.usecases.models;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CreateFlatResponse {
    LocalDate createdDate;
    long id;
    String name;

    public CreateFlatResponse(LocalDate createdDate, long id, String name) {
        this.createdDate = createdDate;
        this.id = id;
        this.name = name;
    }
}
