package com.amos.tenant.management.usecases.Imp;

import com.amos.tenant.management.domain.gateway.EstateDomainGateway;
import com.amos.tenant.management.domain.models.CreateAnEstateResponseDomain;
import com.amos.tenant.management.domain.models.EstateAddress;
import com.amos.tenant.management.usecases.CreateAndRetrievedAllEstate;
import com.amos.tenant.management.usecases.exceptions.GenericInputErrorException;
import com.amos.tenant.management.usecases.models.CreateEstateResponse;
import com.amos.tenant.management.usecases.models.CreateEstateRequest;
import com.amos.tenant.management.usecases.models.RetrievedAllEstateResponse;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Named
public class CreateAndRetrievedAllEstateImpl implements CreateAndRetrievedAllEstate {
   private final EstateDomainGateway estateDomainGateway;

   @Inject
    public CreateAndRetrievedAllEstateImpl(EstateDomainGateway estateDomainGateway) {
        this.estateDomainGateway = estateDomainGateway;
    }

    @Override
    public CreateEstateResponse createAnEstate(CreateEstateRequest request) throws GenericInputErrorException {
        Optional<EstateAddress> address =Optional.ofNullable(request.getEstateDomain().getAddress());
        if(!address.isPresent()){
            throw new GenericInputErrorException("Invalid Estate Address");
        }
        if(request.getEstateDomain().getName().isEmpty()){
            throw  new GenericInputErrorException("Invalid name");
        }
        CreateAnEstateResponseDomain estateDomain=estateDomainGateway.createAnEstate(request.getEstateDomain());
        return new CreateEstateResponse(estateDomain.getId(),estateDomain.getName(),request.getEstateDomain().getAddress());
    }

    @Override
    public List<RetrievedAllEstateResponse> retrievedAllEstateRequest(){
        return estateDomainGateway.retrievedAllEstate().stream().map(a->
                new RetrievedAllEstateResponse(a.getId(),a.getName(),a.getCreatedDate(),a.getAddress())).collect(Collectors.toList());
    }
}
