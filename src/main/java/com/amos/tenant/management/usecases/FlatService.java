package com.amos.tenant.management.usecases;

import com.amos.tenant.management.usecases.exceptions.GenericInputErrorException;
import com.amos.tenant.management.usecases.models.AvailableFlatResponse;
import com.amos.tenant.management.usecases.models.CreateFlatReponse;
import com.amos.tenant.management.usecases.models.CreateFlatRequest;

import java.util.List;


public interface FlatService {
    CreateFlatReponse createFlat(CreateFlatRequest request) throws GenericInputErrorException;
    List<AvailableFlatResponse> viewAll();
}
