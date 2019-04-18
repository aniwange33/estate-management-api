package com.amos.tenant.management.infrastructure.web.controllers;

import com.amos.tenant.management.infrastructure.web.models.AddressJSON;
import com.amos.tenant.management.infrastructure.web.models.AvailableEstateReponseJSON;
import com.amos.tenant.management.infrastructure.web.models.CreateEstateReponseJSON;
import com.amos.tenant.management.infrastructure.web.models.CreateEstateRequestJSON;
import com.amos.tenant.management.usecases.CreateAndRetrievedAllEstate;
import com.amos.tenant.management.usecases.exceptions.GenericInputErrorException;
import com.amos.tenant.management.usecases.models.CreateEstateResponse;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController("api/v1/estate")
@Named
public class EstateController {
    private final CreateAndRetrievedAllEstate createAndRetrievedAllEstate;

    @Inject
    public EstateController(CreateAndRetrievedAllEstate createAndRetrievedAllEstate) {
        this.createAndRetrievedAllEstate = createAndRetrievedAllEstate;
    }


    @PostMapping(value = "/createEaste")
    @ResponseBody
    private CreateEstateReponseJSON createEstate(@RequestHeader("Authorization") String authorization, @Valid  @RequestBody CreateEstateRequestJSON createEstateRequestJSON) throws GenericInputErrorException {
          CreateEstateResponse createEstateResponse = createAndRetrievedAllEstate.createAnEstate(createEstateRequestJSON.getCreateEstateRequest());
          return  new CreateEstateReponseJSON(createEstateResponse);
    }
    @GetMapping(value = "/view")
    private List<AvailableEstateReponseJSON> viewAllEstate(@RequestHeader("Authorization") String authorization){
        return createAndRetrievedAllEstate.retrievedAllEstateRequest().stream().map(a->new AvailableEstateReponseJSON(a.getId(),a.getName(),a.getCreatedDate(),new AddressJSON(a.getAddress().getCity(),a.getAddress().getPlot(),a.getAddress().getStreet(),a.getAddress().getTown()))).collect(Collectors.toList());
    }


}
