package com.amos.tenant.management.infrastructure.data;

import com.amos.tenant.management.domain.enumeration.FlatEnum;
import com.amos.tenant.management.usecases.models.CreateFlatRequest;
import lombok.Data;


@Data
public class CreateFlatRequestJSON {
    String name;
    FlatEnum number;
    long  estateId;
    public CreateFlatRequest getCreatFlatRequest(){
        return new CreateFlatRequest(this.name,this.number,this.estateId);
    }
}
