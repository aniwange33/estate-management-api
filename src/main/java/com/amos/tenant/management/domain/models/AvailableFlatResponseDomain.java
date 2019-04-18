package com.amos.tenant.management.domain.models;

import lombok.Data;

@Data
public class AvailableFlatResponseDomain {
    long id;
    String name;
    String description;
    double price;
    AvailableBlockResponseDomain block;

    public AvailableFlatResponseDomain(long id, String name, String description, double price, AvailableBlockResponseDomain block) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.block = block;
    }
}
