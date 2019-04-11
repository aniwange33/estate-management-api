package com.amos.tenant.management.domain.models;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CreateAnEstateResponseDomain {
    Long id;
    LocalDate createdDate;
    String name;

    public CreateAnEstateResponseDomain(Long id, LocalDate createdDate, String name) {
        this.id = id;
        this.createdDate = createdDate;
        this.name = name;
    }
}
