package com.amos.tenant.management.usecases;

import com.amos.tenant.management.usecases.exceptions.GenericInputErrorException;
import com.amos.tenant.management.usecases.models.AvailableFlat;
import com.amos.tenant.management.usecases.models.CreateFlatRequest;
import com.amos.tenant.management.usecases.models.CreateFlatResponse;

import java.util.List;

public interface CreateAndRetrievedAllFlats {
    CreateFlatResponse createFlat(CreateFlatRequest request) throws GenericInputErrorException;
    List<AvailableFlat> retrievedAllFlats();
}
