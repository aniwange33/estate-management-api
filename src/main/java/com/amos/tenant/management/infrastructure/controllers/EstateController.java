package com.amos.tenant.management.infrastructure.controllers;

import com.amos.tenant.management.infrastructure.data.AddressJSON;
import com.amos.tenant.management.infrastructure.data.AvailableEstateReponseJSON;
import com.amos.tenant.management.infrastructure.data.CreateEstateReponseJSON;
import com.amos.tenant.management.infrastructure.data.CreateEstateRequestJSON;
import com.amos.tenant.management.usecases.EstateService;
import com.amos.tenant.management.usecases.models.CreateEstateReponse;
import com.amos.tenant.management.usecases.exceptions.GenericInputErrorException;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController("api/v1/estate")
@Named
public class EstateController {


    private final EstateService estateService;

    @Inject
    public EstateController(EstateService estateService) {
        this.estateService = estateService;
    }

    @PostMapping(value = "/createEaste")
    @ResponseBody
    private CreateEstateReponseJSON createEstate(@Valid  @RequestBody CreateEstateRequestJSON createEstateRequestJSON) throws GenericInputErrorException {
        CreateEstateReponse createEstateReponse= estateService.createEstate(createEstateRequestJSON.getCreateEstateRequest());
          return  new CreateEstateReponseJSON(createEstateReponse);
    }
    @GetMapping(value = "/view")
    private List<AvailableEstateReponseJSON> viewAllEstate(){
        return estateService.viewAllEstate().stream().map(a->new AvailableEstateReponseJSON(a.getId(),a.getName(),a.getCreateDate(),new AddressJSON(a.getAddress().getCity(),a.getAddress().getPlot(),a.getAddress().getStreet(),a.getAddress().getTown()))).collect(Collectors.toList());
    }


}
