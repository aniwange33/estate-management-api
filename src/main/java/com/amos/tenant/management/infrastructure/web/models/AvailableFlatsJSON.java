package com.amos.tenant.management.infrastructure.web.models;

import lombok.Data;

@Data
public class AvailableFlatsJSON {
    long id;
    String name;
    String description;
    double price;
    AvailableBlockResponseJSON block;

    public AvailableFlatsJSON(long id, String name, String description, double price, AvailableBlockResponseJSON block) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.block = block;
    }
}
