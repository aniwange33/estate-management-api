package com.amos.tenant.management.domain.models;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AvaliableEstateResponseDomain {
    Long id;
    String name;
    LocalDate createdDate;
    EstateAddress address;

    public AvaliableEstateResponseDomain(Long id, String name, LocalDate createdDate, EstateAddress address) {
        this.id = id;
        this.name = name;
        this.createdDate = createdDate;
        this.address = address;
    }
}
