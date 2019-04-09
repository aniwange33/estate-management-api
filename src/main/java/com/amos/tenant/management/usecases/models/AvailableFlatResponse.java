package com.amos.tenant.management.usecases.models;

import com.amos.tenant.management.domain.enumeration.FlatEnum;
import lombok.Data;
@Data
public class AvailableFlatResponse {
    private long id;
    private  String name;
    private FlatEnum number;
    private AvailableEstateResponse estate;

    public AvailableFlatResponse(long id, String name, FlatEnum number, AvailableEstateResponse estate) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.estate = estate;
    }
}
