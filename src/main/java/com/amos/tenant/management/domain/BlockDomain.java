package com.amos.tenant.management.domain;

import lombok.Data;

@Data
public class BlockDomain {
    String name;
    Long  numberOfFlats;

    public BlockDomain(String name, Long numberOfFlats) {
        this.name = name;
        this.numberOfFlats = numberOfFlats;
    }
}
