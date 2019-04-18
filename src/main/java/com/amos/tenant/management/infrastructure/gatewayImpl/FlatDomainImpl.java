package com.amos.tenant.management.infrastructure.gatewayImpl;

import com.amos.tenant.management.domain.gateway.FlatDomainGateway;
import com.amos.tenant.management.domain.models.AvailableBlockResponseDomain;
import com.amos.tenant.management.domain.models.AvailableFlatResponseDomain;
import com.amos.tenant.management.domain.models.CreateFlatDomainRequest;
import com.amos.tenant.management.domain.models.CreateFlatDomainResponse;
import com.amos.tenant.management.infrastructure.persistence.entities.BlockDbEntity;
import com.amos.tenant.management.infrastructure.persistence.entities.FlatDbEntity;
import com.amos.tenant.management.infrastructure.persistence.repositories.BlockDbEntityRepo;
import com.amos.tenant.management.infrastructure.persistence.repositories.FlatDbEntityRepo;
import com.amos.tenant.management.usecases.exceptions.GenericInputErrorException;

import javax.inject.Inject;
import javax.inject.Named;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Named
public class FlatDomainImpl implements FlatDomainGateway {
    private final FlatDbEntityRepo flatDbEntityRepo;
    private final BlockDbEntityRepo blockDbEntityRepo;

    @Inject
    public FlatDomainImpl(FlatDbEntityRepo flatDbEntityRepo, BlockDbEntityRepo blockDbEntityRepo) {
        this.flatDbEntityRepo = flatDbEntityRepo;
        this.blockDbEntityRepo = blockDbEntityRepo;
    }




    @Override
    public CreateFlatDomainResponse createFlat(CreateFlatDomainRequest request) throws GenericInputErrorException {
       Optional<BlockDbEntity> blockDbEntityOptional=blockDbEntityRepo.findById(request.getBlockId());
       if(!blockDbEntityOptional.isPresent()){
           throw  new  GenericInputErrorException("Invalid Block Id");
       }
       FlatDbEntity flatDbEntity=new FlatDbEntity(request.getName(),request.getDescription(),request.getPrice(),blockDbEntityOptional.get());
       flatDbEntity.setCreatedDate(LocalDate.now());
       flatDbEntityRepo.save(flatDbEntity);
        return new CreateFlatDomainResponse(flatDbEntity.getCreatedDate(),flatDbEntity.getId(),flatDbEntity.getName());
    }

    @Override
    public List<AvailableFlatResponseDomain> retrievedAllFlats() {
        return flatDbEntityRepo.findAll().stream().map(a->new AvailableFlatResponseDomain(a.getId(),a.getName(),a.getDescription(),a.getPrice(),
                new AvailableBlockResponseDomain(a.getBlockDbEntity().getId(),a.getBlockDbEntity().getName(),a.getBlockDbEntity().getNumberOfFlat(),a.getBlockDbEntity().getCreatedDate()))).collect(Collectors.toList());
    }
}
