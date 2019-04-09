package com.amos.tenant.management.usecases.serviceImp;


import com.amos.tenant.management.domain.entities.Address;
import com.amos.tenant.management.domain.entities.Estate;
import com.amos.tenant.management.domain.repositories.EstateRepo;
import com.amos.tenant.management.usecases.EstateService;
import com.amos.tenant.management.usecases.models.AvailableEstateResponse;
import com.amos.tenant.management.usecases.models.CreateEstateReponse;
import com.amos.tenant.management.usecases.models.CreateEstateRequest;
import com.amos.tenant.management.usecases.exceptions.GenericInputErrorException;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.stream.Collectors;

@Named
public class EstateServiceImpl implements EstateService {

    private final EstateRepo estateRepo;

    @Inject
    public EstateServiceImpl(EstateRepo estateRepo) {
        this.estateRepo = estateRepo;
    }

    @Override
    public CreateEstateReponse createEstate(CreateEstateRequest request) throws GenericInputErrorException {
        if(request.getName().isEmpty()){
            throw new GenericInputErrorException("Invalid estate name");
        }

        Estate estate=new Estate(request.getName(), new Address(request.getCity(),request.getPlotNumber(),request.getStreet(),request.getTown()));
        estate.setCreatedDate(request.getDateCreated());
        estateRepo.save(estate);
        return new CreateEstateReponse(estate.getId(),estate.getName(),estate.getAddress());
    }

    @Override
    public List<AvailableEstateResponse> viewAllEstate() {
       return estateRepo.findAll().stream().map(a->new AvailableEstateResponse(a.getId(),a.getName(),a.getCreatedDate(),a.getAddress())).collect(Collectors.toList());
    }
}
