package com.amos.tenant.management.infrastructure.persistence.entities.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class Name {
    String firstName;
    String lastName;
    String middleName;
}
