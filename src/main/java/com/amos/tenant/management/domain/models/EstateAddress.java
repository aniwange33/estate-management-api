package com.amos.tenant.management.domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EstateAddress {
    private String  city;
    private String  plot;
    private String  street;
    private String  town;

}
