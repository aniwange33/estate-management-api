package com.amos.tenant.management.usecases.models;

import lombok.Data;

@Data
public class CreateFlatRequest {
    long  blockId;
    String name;
    String description;
    double price;

    public CreateFlatRequest(long blockId, String name, String description) {
        this.blockId = blockId;
        this.name = name;
        this.description = description;
    }
}
