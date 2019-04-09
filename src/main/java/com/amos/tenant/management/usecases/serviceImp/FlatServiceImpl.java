package com.amos.tenant.management.usecases.serviceImp;

import com.amos.tenant.management.domain.entities.Address;
import com.amos.tenant.management.domain.entities.Estate;
import com.amos.tenant.management.domain.entities.Flat;
import com.amos.tenant.management.domain.repositories.EstateRepo;
import com.amos.tenant.management.domain.repositories.FlateRepo;
import com.amos.tenant.management.usecases.FlatService;
import com.amos.tenant.management.usecases.models.AvailableEstateResponse;
import com.amos.tenant.management.usecases.models.AvailableFlatResponse;
import com.amos.tenant.management.usecases.models.CreateFlatReponse;
import com.amos.tenant.management.usecases.models.CreateFlatRequest;
import com.amos.tenant.management.usecases.exceptions.GenericInputErrorException;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Named
public class FlatServiceImpl implements FlatService {

   private final  FlateRepo flateRepo;

    private final EstateRepo estateRepo;
       @Inject
    public FlatServiceImpl(FlateRepo flateRepo, EstateRepo estateRepo) {
        this.flateRepo = flateRepo;
        this.estateRepo = estateRepo;
    }

    @Override
    public CreateFlatReponse createFlat(CreateFlatRequest request) throws GenericInputErrorException {
        System.out.println("Amos is here ");


        Optional<Estate> estate = Optional.ofNullable(estateRepo.findById(request.getEstateId()));
        if (!estate.isPresent()) {
            throw new GenericInputErrorException("Invalid Estate Id");
        }
        System.out.println("Amos is here " + estate.toString());
        Flat flat = new Flat(request.getName(), request.getNumber(), estate.get());
        flat.setCreatedDate(request.getDateCreated());
        System.out.println("Amos 33@");
        flateRepo.save(flat);
        return new CreateFlatReponse(flat.getId(),flat.getName());
    }

    @Override
    public List<AvailableFlatResponse> viewAll() {
        return flateRepo.findAll().stream().
                map(a -> new AvailableFlatResponse(a.getId(), a.getName(), a.getNumber(),
                new AvailableEstateResponse(a.getEstate().getId(), a.getEstate().getName(), a.getEstate().getCreatedDate(),
                        new Address(a.getEstate().getAddress().getCity(), a.getEstate().getAddress().getPlot(), a.getEstate().getAddress().getStreet(), a.getEstate().getAddress().getTown())
                        )))
                .collect(Collectors.toList());
    }
}
