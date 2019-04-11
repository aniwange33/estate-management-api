package com.amos.tenant.management.infrastructure.web.models;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class AvailableEstateReponseJSON {
    private Long  id;
    private String name;
    private LocalDate createDate;
    private AddressJSON address;

    public AvailableEstateReponseJSON(Long id, String name, LocalDate createDate, AddressJSON address) {
        this.id = id;
        this.name = name;
        this.createDate = createDate;
        this.address = address;
    }
}
