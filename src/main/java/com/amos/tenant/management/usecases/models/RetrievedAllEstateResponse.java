package com.amos.tenant.management.usecases.models;

import com.amos.tenant.management.domain.models.EstateAddress;
import lombok.Data;

import java.time.LocalDate;

@Data
public class RetrievedAllEstateResponse {
    Long id;
    String name;
    LocalDate createdDate;
    EstateAddress address;

    public RetrievedAllEstateResponse(Long id, String name, LocalDate createdDate, EstateAddress address) {
        this.id = id;
        this.name = name;
        this.createdDate = createdDate;
        this.address = address;
    }
}
