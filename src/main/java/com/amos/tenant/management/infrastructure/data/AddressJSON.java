package com.amos.tenant.management.infrastructure.data;

import lombok.Data;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
@Data
public class AddressJSON {
    @NotNull
    private String  city;
    @NotNull
    private String  plot;
    @NotNull
    private String  street;
    @NotNull
    private String  town;

    public AddressJSON(@NotNull String city, @NotNull String plot, @NotNull String street, @NotNull String town) {
        this.city = city;
        this.plot = plot;
        this.street = street;
        this.town = town;
    }
}
