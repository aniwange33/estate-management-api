package com.amos.tenant.management.usecases;

import com.amos.tenant.management.usecases.models.AvailableEstateResponse;
import com.amos.tenant.management.usecases.models.CreateEstateReponse;
import com.amos.tenant.management.usecases.models.CreateEstateRequest;
import com.amos.tenant.management.usecases.exceptions.GenericInputErrorException;

import java.util.List;


public interface EstateService {
   CreateEstateReponse createEstate(CreateEstateRequest request) throws GenericInputErrorException;
    List<AvailableEstateResponse> viewAllEstate();

}
