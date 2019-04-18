package com.amos.tenant.management.domain.models;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CreateFlatDomainResponse {
    LocalDate createdDate;
    long id;
    String name;

    public CreateFlatDomainResponse(LocalDate createdDate, long id, String name) {
        this.createdDate = createdDate;
        this.id = id;
        this.name = name;
    }
}
