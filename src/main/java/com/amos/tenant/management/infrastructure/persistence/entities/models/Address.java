package com.amos.tenant.management.infrastructure.persistence.entities.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Address {
    private String  city;
    private String  plot;
    private String  street;
    private String  town;


}
