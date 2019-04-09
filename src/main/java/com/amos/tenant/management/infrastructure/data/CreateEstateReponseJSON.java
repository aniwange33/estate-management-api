package com.amos.tenant.management.infrastructure.data;

import com.amos.tenant.management.domain.entities.Address;
import com.amos.tenant.management.usecases.models.CreateEstateReponse;
import lombok.Data;

@Data
public class CreateEstateReponseJSON {
    Long id;
    String name;
    Address address;

    public CreateEstateReponseJSON(CreateEstateReponse createEstateReponse) {
        this.id = createEstateReponse.getId();
        this.name = createEstateReponse.getName();
        this.address=createEstateReponse.getAddress();
    }
}
