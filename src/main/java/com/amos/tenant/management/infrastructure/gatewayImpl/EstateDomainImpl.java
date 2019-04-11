package com.amos.tenant.management.infrastructure.gatewayImpl;

import com.amos.tenant.management.domain.EstateDomain;
import com.amos.tenant.management.domain.gateway.EstateDomainGateway;
import com.amos.tenant.management.domain.models.AvaliableEstateResponseDomain;
import com.amos.tenant.management.domain.models.CreateAnEstateResponseDomain;
import com.amos.tenant.management.domain.models.EstateAddress;
import com.amos.tenant.management.infrastructure.persistence.entities.EstateDbEntity;
import com.amos.tenant.management.infrastructure.persistence.entities.models.Address;
import com.amos.tenant.management.infrastructure.persistence.repositories.EstateDbEntityRepo;

import javax.inject.Inject;
import javax.inject.Named;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Named
public class EstateDomainImpl implements EstateDomainGateway {
    private final EstateDbEntityRepo estateDbEntityRepo;
     @Inject
    public EstateDomainImpl(EstateDbEntityRepo estateDbEntityRepo) {
        this.estateDbEntityRepo = estateDbEntityRepo;
    }

    @Override
    public CreateAnEstateResponseDomain createAnEstate(EstateDomain request) {
        EstateDbEntity estateDbEntity=new EstateDbEntity(request.getName(),new Address(request.getAddress().getCity(),request.getAddress().getPlot(),request.getAddress().getStreet(),request.getAddress().getTown()));
        estateDbEntity.setCreatedDate(LocalDate.now());
        estateDbEntityRepo.save(estateDbEntity);
        return new CreateAnEstateResponseDomain(estateDbEntity.getId(),estateDbEntity.getCreatedDate(),estateDbEntity.getName());

    }

    @Override
    public List<AvaliableEstateResponseDomain> retrievedAllEstate() {
        return estateDbEntityRepo.findAll().stream().map(a->new AvaliableEstateResponseDomain(a.getId(),a.getName(),a.getCreatedDate(),
                new EstateAddress(a.getAddress().getCity(),a.getAddress().getPlot(),a.getAddress().getStreet(),a.getAddress().getTown()
               ))).collect(Collectors.toList());
    }
}
