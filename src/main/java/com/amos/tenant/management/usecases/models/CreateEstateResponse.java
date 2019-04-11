package com.amos.tenant.management.usecases.models;

import com.amos.tenant.management.domain.models.EstateAddress;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CreateEstateResponse {

    Long id;
    LocalDate createdDate;
    String name;
    EstateAddress address;

    public CreateEstateResponse(Long id, String name, EstateAddress address) {
        this.id = id;
        this.createdDate = LocalDate.now();
        this.name = name;
        this.address = address;
    }
}
