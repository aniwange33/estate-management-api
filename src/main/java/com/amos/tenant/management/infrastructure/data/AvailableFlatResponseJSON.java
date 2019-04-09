package com.amos.tenant.management.infrastructure.data;

import com.amos.tenant.management.domain.enumeration.FlatEnum;
import lombok.Data;

@Data
public class AvailableFlatResponseJSON {
    private Long id;
    private  String name;
    private FlatEnum number;
    private AvailableEstateReponseJSON estate;

    public AvailableFlatResponseJSON(Long id, String name, FlatEnum number, AvailableEstateReponseJSON estate) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.estate = estate;
    }
}
