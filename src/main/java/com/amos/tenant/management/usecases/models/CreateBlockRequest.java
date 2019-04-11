package com.amos.tenant.management.usecases.models;

import com.amos.tenant.management.domain.BlockDomain;
import lombok.Data;

@Data
public class CreateBlockRequest {
    Long estatId;
    BlockDomain block;

    public CreateBlockRequest(Long estatId, BlockDomain block) {
        this.estatId = estatId;
        this.block = block;
    }
}
