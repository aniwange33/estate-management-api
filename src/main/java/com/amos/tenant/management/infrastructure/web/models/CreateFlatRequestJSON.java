package com.amos.tenant.management.infrastructure.web.models;

import com.amos.tenant.management.usecases.models.CreateFlatRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.NotNull;

@Data
public class CreateFlatRequestJSON {
    @NotNull
    long  blockId;
    @NotNull
    String name;
    @NotNull
    String description;
    @NumberFormat
    double price;

    @JsonIgnore
    public CreateFlatRequest getCreateFlatRequest(){
        CreateFlatRequest  request =new CreateFlatRequest(this.blockId,this.name,this.description);
        request.setPrice(this.price);
        return request;
    }
}
