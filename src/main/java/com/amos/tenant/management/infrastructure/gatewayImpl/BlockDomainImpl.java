package com.amos.tenant.management.infrastructure.gatewayImpl;

import com.amos.tenant.management.domain.gateway.BlockDomainGateway;
import com.amos.tenant.management.domain.models.AvailableBlockResponseDomain;
import com.amos.tenant.management.domain.models.CreateABlockRequestDomain;
import com.amos.tenant.management.domain.models.CreateABlockResponseDomain;
import com.amos.tenant.management.infrastructure.persistence.entities.BlockDbEntity;
import com.amos.tenant.management.infrastructure.persistence.entities.EstateDbEntity;
import com.amos.tenant.management.infrastructure.persistence.repositories.BlockDbEntityRepo;
import com.amos.tenant.management.infrastructure.persistence.repositories.EstateDbEntityRepo;
import com.amos.tenant.management.usecases.exceptions.GenericInputErrorException;

import javax.inject.Inject;
import javax.inject.Named;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Named
public class BlockDomainImpl implements BlockDomainGateway {
    private final BlockDbEntityRepo blockDbEntityRepo;
    private final EstateDbEntityRepo estateDbEntityRepo;

      @Inject
    public BlockDomainImpl(BlockDbEntityRepo blockDbEntityRepo, EstateDbEntityRepo estateDbEntityRepo) {
        this.blockDbEntityRepo = blockDbEntityRepo;
        this.estateDbEntityRepo = estateDbEntityRepo;
    }

    @Override
    public CreateABlockResponseDomain createABlock(CreateABlockRequestDomain request) throws GenericInputErrorException  {
        Optional<EstateDbEntity>estateDbEntity =Optional.ofNullable(estateDbEntityRepo.findById(request.getEstateId()));
        if(!estateDbEntity.isPresent()){
            throw new GenericInputErrorException("Invalid Estate Id!!");
        }
        BlockDbEntity blockDbEntity=new BlockDbEntity(request.getBlockDomain().getName(),request.getBlockDomain().getNumberOfFlats(),estateDbEntity.get());
        blockDbEntity.setCreatedDate(LocalDate.now());
        blockDbEntityRepo.save(blockDbEntity);
        return new CreateABlockResponseDomain(blockDbEntity.getId(),blockDbEntity.getName(),blockDbEntity.getCreatedDate());
    }

    @Override
    public List<AvailableBlockResponseDomain> retrievedAllBlocks() {
        return blockDbEntityRepo.findAll().stream().map(a->new AvailableBlockResponseDomain(a.getId(),a.getName(),a.getNumberOfFlat(),a.getCreatedDate())).collect(Collectors.toList());
    }
}
