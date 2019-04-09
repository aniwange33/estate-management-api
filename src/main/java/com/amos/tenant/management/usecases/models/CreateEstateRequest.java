package com.amos.tenant.management.usecases.models;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CreateEstateRequest {
    String plotNumber;
    String street;
    String town;
    String city;
    String name;
    LocalDate dateCreated;

    public CreateEstateRequest(String plotNumber, String street, String town, String city, String name) {
        this.plotNumber = plotNumber;
        this.street = street;
        this.town = town;
        this.city = city;
        this.dateCreated=LocalDate.now();
        if(name!=null || ! name.isEmpty()){
            this.name = name;
        }

    }


}
