package com.amos.tenant.management.usecases.models;

import com.amos.tenant.management.domain.enumeration.FlatEnum;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CreateFlatRequest {
    String name;
    FlatEnum number;
    long  estateId;
    LocalDate dateCreated;

    public CreateFlatRequest(String name, FlatEnum number, long estateId) {
        this.name = name;
        this.number = number;
        this.estateId = estateId;
        this.dateCreated = LocalDate.now();
    }
}
