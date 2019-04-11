package com.amos.tenant.management.infrastructure.web.models;

import com.amos.tenant.management.infrastructure.persistence.entities.models.Address;
import com.amos.tenant.management.usecases.models.CreateEstateResponse;
import lombok.Data;

@Data
public class CreateEstateReponseJSON {
    Long id;
    String name;
    Address address;

    public CreateEstateReponseJSON(CreateEstateResponse createEstateReponse) {
        this.id = createEstateReponse.getId();
        this.name = createEstateReponse.getName();
        this.address= new Address(createEstateReponse.getAddress().getCity(),createEstateReponse.getAddress().getPlot(),createEstateReponse.getAddress().getStreet(), createEstateReponse.getAddress().getTown());
    }
}
