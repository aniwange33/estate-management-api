package com.amos.tenant.management.usecases.Imp;
import com.amos.tenant.management.domain.BlockDomain;
import com.amos.tenant.management.domain.gateway.BlockDomainGateway;
import com.amos.tenant.management.domain.models.CreateABlockRequestDomain;
import com.amos.tenant.management.domain.models.CreateABlockResponseDomain;
import com.amos.tenant.management.usecases.CreateAndRetrievedAllBlock;
import com.amos.tenant.management.usecases.exceptions.GenericInputErrorException;
import com.amos.tenant.management.usecases.models.CreateBlockRequest;
import com.amos.tenant.management.usecases.models.CreateBlockResponse;
import com.amos.tenant.management.usecases.models.RetrievedAllBlocksResponse;
import javax.inject.Named;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Named
public class CreateAndRetrievedAllBlockImpl  implements CreateAndRetrievedAllBlock {
    private final BlockDomainGateway blockDomainGateway;

    public CreateAndRetrievedAllBlockImpl(BlockDomainGateway blockDomainGateway) {
        this.blockDomainGateway = blockDomainGateway;
    }

    @Override
    public CreateBlockResponse createABlock(CreateBlockRequest blockRequest) throws GenericInputErrorException {
        Optional<BlockDomain> blockDomain = Optional.ofNullable(blockRequest.getBlock());
        if (!blockDomain.isPresent()) {
            throw new GenericInputErrorException("Invalid request");
        }
        if (blockRequest.getBlock().getName().isEmpty()) {
            throw new GenericInputErrorException("Invalid Block name");
        }
        if (blockRequest.getBlock().getNumberOfFlats() < 1) {
            throw new GenericInputErrorException("Invalid number of blocks");
        }
        CreateABlockResponseDomain createBlockResponse = blockDomainGateway.createABlock(new CreateABlockRequestDomain(blockRequest.getEstatId(),blockRequest.getBlock()));
        return new CreateBlockResponse(createBlockResponse.getId(), createBlockResponse.getName(), createBlockResponse.getDate());
    }

    @Override
    public List<RetrievedAllBlocksResponse> retrievedAllBlocks() {
        return blockDomainGateway.retrievedAllBlocks().stream().map(a -> new RetrievedAllBlocksResponse(a.getId(), a.getName(), a.getNumberOfFlats(), a.getDate())).collect(Collectors.toList());
    }
}