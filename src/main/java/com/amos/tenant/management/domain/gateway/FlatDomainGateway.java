package com.amos.tenant.management.domain.gateway;

import com.amos.tenant.management.domain.models.AvailableFlatResponseDomain;
import com.amos.tenant.management.domain.models.CreateFlatDomainResponse;
import com.amos.tenant.management.domain.models.CreateFlatDomainRequest;
import com.amos.tenant.management.usecases.exceptions.GenericInputErrorException;

import java.util.List;

public interface FlatDomainGateway {
    CreateFlatDomainResponse createFlat(CreateFlatDomainRequest request)throws GenericInputErrorException;
    List<AvailableFlatResponseDomain> retrievedAllFlats();
}
