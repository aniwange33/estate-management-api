package com.amos.tenant.management.domain;

import lombok.Data;

@Data
public class FlatDomain {
    String name;
    String description;
    double price;

    public FlatDomain(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }
}
