package com.amos.tenant.management.usecases.models;

import com.amos.tenant.management.domain.entities.Address;
import lombok.Data;

import java.time.LocalDate;

@Data
public class AvailableEstateResponse {
    private Long  id;
    private String name;
    private LocalDate createDate;
    private Address address;

    public AvailableEstateResponse(Long id, String name, LocalDate createDate, Address address) {
        this.id = id;
        this.name = name;
        this.createDate = createDate;
        this.address = address;
    }
}
