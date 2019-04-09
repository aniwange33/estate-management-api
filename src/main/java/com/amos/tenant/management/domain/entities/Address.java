package com.amos.tenant.management.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@NoArgsConstructor
@Data
@AllArgsConstructor
public class Address {
    private String  city;
    private String  plot;
    private String  street;
    private String  town;


}
