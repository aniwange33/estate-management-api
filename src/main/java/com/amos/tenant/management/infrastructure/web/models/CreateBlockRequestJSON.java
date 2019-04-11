package com.amos.tenant.management.infrastructure.web.models;

import com.amos.tenant.management.domain.BlockDomain;
import com.amos.tenant.management.usecases.models.CreateBlockRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.format.annotation.NumberFormat;
import javax.validation.constraints.NotNull;


@Data
public class CreateBlockRequestJSON {
    @NotNull
    String name;
    @NotNull
    Long estateId;
    @NumberFormat
    Long numberOfFlats;

    @JsonIgnore
    public CreateBlockRequest getCreateBlockRequest() {
        return new CreateBlockRequest(this.estateId,new BlockDomain(this.name,this.numberOfFlats));
    }
}
