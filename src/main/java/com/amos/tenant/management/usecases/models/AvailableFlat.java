package com.amos.tenant.management.usecases.models;

import com.amos.tenant.management.domain.models.AvailableBlockResponseDomain;
import lombok.Data;

@Data
public class AvailableFlat {
    long id;
    String name;
    String description;
    double price;
    AvailableBlockResponseDomain block;

    public AvailableFlat(long id, String name, String description, double price, AvailableBlockResponseDomain block) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.block = block;
    }
}
