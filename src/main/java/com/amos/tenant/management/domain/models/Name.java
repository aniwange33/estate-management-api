package com.amos.tenant.management.domain.models;

import lombok.Data;

@Data
public class Name {
    String firstName;
    String lastName;
    String middleName;

    public Name(String firstName, String lastName, String middleName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
    }
}
