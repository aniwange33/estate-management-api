package com.amos.tenant.management.infrastructure.web.models;

import com.amos.tenant.management.domain.EstateDomain;
import com.amos.tenant.management.domain.models.EstateAddress;
import com.amos.tenant.management.usecases.models.CreateEstateRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class CreateEstateRequestJSON {
    @Size(min = 3)
    String city;
    @Size(min = 2)
    String name;
    @NotNull
    String plotNumber;
    @NotNull
    String street;
    @Size(min = 3)
    String town;


    @JsonIgnore
   public CreateEstateRequest getCreateEstateRequest(){
        EstateAddress address=new EstateAddress(this.city,this.plotNumber,this.town,this.street);
        EstateDomain estateDomain=new EstateDomain(address,this.name);
        return  new CreateEstateRequest(estateDomain) ;

    }
}
