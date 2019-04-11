package com.amos.tenant.management.usecases;

import com.amos.tenant.management.usecases.exceptions.GenericInputErrorException;
import com.amos.tenant.management.usecases.models.CreateEstateResponse;
import com.amos.tenant.management.usecases.models.CreateEstateRequest;
import com.amos.tenant.management.usecases.models.RetrievedAllEstateResponse;

import java.util.List;

public interface CreateAndRetrievedAllEstate {
    CreateEstateResponse createAnEstate(CreateEstateRequest request) throws GenericInputErrorException;
    List<RetrievedAllEstateResponse> retrievedAllEstateRequest();
}
