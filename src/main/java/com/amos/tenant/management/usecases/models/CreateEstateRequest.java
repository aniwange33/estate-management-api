package com.amos.tenant.management.usecases.models;

import com.amos.tenant.management.domain.EstateDomain;
import lombok.Data;

@Data
public class CreateEstateRequest {
    EstateDomain estateDomain;
    public CreateEstateRequest(EstateDomain estateDomain) {
        this.estateDomain = estateDomain;
    }
}
