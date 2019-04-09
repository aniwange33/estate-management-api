package com.amos.tenant.management.infrastructure.data;

import com.amos.tenant.management.usecases.models.CreateEstateRequest;
import lombok.Data;

@Data
public class CreateEstateRequestJSON {

    String plotNumber;
    String street;
    String town;
    String city;
    String name;

    public CreateEstateRequest getCreateEstateRequest(){
    return  new CreateEstateRequest(this.plotNumber, this. street, this. town, this. city, this. name) ;

    }
}
