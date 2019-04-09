package com.amos.tenant.management.usecases.models;

import com.amos.tenant.management.domain.entities.Address;
import lombok.Data;

@Data
public class CreateEstateReponse {
    Long id;
    String name;
    Address address;

    public CreateEstateReponse(Long id, String name,Address address) {
        this.id = id;
        this.name = name;
        this.address=address;
    }

}
