package com.amos.tenant.management.infrastructure.data;

import lombok.Data;

@Data
public class CreateFlatResponseJSON {
    long id;
    String name;

    public CreateFlatResponseJSON(long id, String name) {
        this.id = id;
        this.name = name;
    }
}
