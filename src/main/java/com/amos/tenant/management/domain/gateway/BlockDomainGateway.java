package com.amos.tenant.management.domain.gateway;

import com.amos.tenant.management.domain.models.AvailableBlockResponseDomain;
import com.amos.tenant.management.domain.models.CreateABlockRequestDomain;
import com.amos.tenant.management.domain.models.CreateABlockResponseDomain;
import com.amos.tenant.management.usecases.exceptions.GenericInputErrorException;

import java.util.List;

public interface BlockDomainGateway {
    CreateABlockResponseDomain createABlock(CreateABlockRequestDomain request) throws GenericInputErrorException;
    List<AvailableBlockResponseDomain> retrievedAllBlocks();

}
