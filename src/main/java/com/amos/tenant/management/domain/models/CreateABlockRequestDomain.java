package com.amos.tenant.management.domain.models;

import com.amos.tenant.management.domain.BlockDomain;
import lombok.Data;

@Data
public class CreateABlockRequestDomain {
    long estateId;
    BlockDomain blockDomain;

    public CreateABlockRequestDomain(Long estateId, BlockDomain blockDomain) {
        this.estateId = estateId;
        this.blockDomain = blockDomain;
    }
}
