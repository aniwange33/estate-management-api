package com.amos.tenant.management.domain;

import com.amos.tenant.management.domain.models.EstateAddress;
import lombok.Data;

@Data
public class EstateDomain {
    String name;
    EstateAddress address;


    public EstateDomain(EstateAddress address, String name) {
        this.address = address;
        this.name = name;


    }
}

