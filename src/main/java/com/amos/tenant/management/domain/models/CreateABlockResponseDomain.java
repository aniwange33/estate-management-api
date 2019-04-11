package com.amos.tenant.management.domain.models;

import lombok.Data;

import java.time.LocalDate;
@Data
public class CreateABlockResponseDomain {
    Long id;
    String name;
    LocalDate date;


    public CreateABlockResponseDomain(Long id, String name, LocalDate date) {
        this.id = id;
        this.name = name;
        this.date = date;
    }
}
