package com.amos.tenant.management.usecases;

import com.amos.tenant.management.usecases.exceptions.GenericInputErrorException;
import com.amos.tenant.management.usecases.models.CreateBlockRequest;
import com.amos.tenant.management.usecases.models.CreateBlockResponse;
import com.amos.tenant.management.usecases.models.RetrievedAllBlocksResponse;

import java.util.List;

public interface CreateAndRetrievedAllBlock {
    CreateBlockResponse createABlock(CreateBlockRequest blockRequest) throws GenericInputErrorException;
   List<RetrievedAllBlocksResponse> retrievedAllBlocks();
}
