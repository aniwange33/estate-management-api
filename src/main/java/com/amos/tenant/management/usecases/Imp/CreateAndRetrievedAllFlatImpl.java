package com.amos.tenant.management.usecases.Imp;

import com.amos.tenant.management.domain.gateway.FlatDomainGateway;
import com.amos.tenant.management.domain.models.CreateFlatDomainRequest;
import com.amos.tenant.management.domain.models.CreateFlatDomainResponse;
import com.amos.tenant.management.usecases.CreateAndRetrievedAllFlats;
import com.amos.tenant.management.usecases.exceptions.GenericInputErrorException;
import com.amos.tenant.management.usecases.models.AvailableFlat;
import com.amos.tenant.management.usecases.models.CreateFlatRequest;
import com.amos.tenant.management.usecases.models.CreateFlatResponse;

import javax.inject.Inject;
import javax.inject.Named;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Named
public class CreateAndRetrievedAllFlatImpl implements CreateAndRetrievedAllFlats {
    private final FlatDomainGateway flatDomainGateway;

    @Inject
    public CreateAndRetrievedAllFlatImpl(FlatDomainGateway flatDomainGateway) {
        this.flatDomainGateway = flatDomainGateway;
    }

    @Override
    public CreateFlatResponse createFlat(CreateFlatRequest request) throws GenericInputErrorException{
        if(request.getPrice()<1.0){
            throw new GenericInputErrorException("Invalid flat Price");
        }
        CreateFlatDomainRequest domainRequest=new CreateFlatDomainRequest(request.getBlockId(),request.getName(),request.getDescription());
        domainRequest.setPrice(request.getPrice());
        CreateFlatDomainResponse createFlatDomainResponse=flatDomainGateway.createFlat(domainRequest);
        return new CreateFlatResponse(LocalDate.now(),createFlatDomainResponse.getId(),createFlatDomainResponse.getName());
    }

    @Override
    public List<AvailableFlat> retrievedAllFlats() {
        return  flatDomainGateway.retrievedAllFlats().stream().map(a->new AvailableFlat(a.getId(),a.getName(),a.getDescription(),a.getPrice(),a.getBlock())).collect(Collectors.toList());
    }
}
