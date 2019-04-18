package com.amos.tenant.management.domain.models;

import lombok.Data;

@Data
public class CreateFlatDomainRequest {
    long  blockId;
    String name;
    String description;
    double price;

    public CreateFlatDomainRequest(long blockId, String name, String description) {
        this.blockId = blockId;
        this.name = name;
        this.description = description;
    }
}
