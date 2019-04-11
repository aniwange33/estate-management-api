package com.amos.tenant.management.usecases.models;

import lombok.Data;

import java.time.LocalDate;

@Data
public class RetrievedAllBlocksResponse {
    Long  id;
    String name;
    Long  numberOfFlats;
    LocalDate CreatedDate;

    public RetrievedAllBlocksResponse(Long id, String name, Long numberOfFlats, LocalDate createdDate) {
        this.id = id;
        this.name = name;
        this.numberOfFlats = numberOfFlats;
        CreatedDate = createdDate;
    }
}
