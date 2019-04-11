package com.amos.tenant.management.domain.models;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AvailableBlockResponseDomain {
    Long id;
    String name;
    Long  numberOfFlats;
    LocalDate date;

    public AvailableBlockResponseDomain(Long id, String name, Long numberOfFlats, LocalDate date) {
        this.id = id;
        this.name = name;
        this.numberOfFlats = numberOfFlats;
        this.date = date;
    }
}
