package com.amos.tenant.management.infrastructure.web.controllers;

import com.amos.tenant.management.infrastructure.web.models.AvailableBlockResponseJSON;
import com.amos.tenant.management.infrastructure.web.models.AvailableFlatsJSON;
import com.amos.tenant.management.infrastructure.web.models.CreateFlatRequestJSON;
import com.amos.tenant.management.infrastructure.web.models.CreateFlatResponseJSON;
import com.amos.tenant.management.usecases.CreateAndRetrievedAllFlats;
import com.amos.tenant.management.usecases.exceptions.GenericInputErrorException;
import com.amos.tenant.management.usecases.models.CreateFlatResponse;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Named
@RestController(value = "api/v1/flat")
public class FlatController {
   private final  CreateAndRetrievedAllFlats createAndRetrievedAllFlats;
      @Inject
    public FlatController(CreateAndRetrievedAllFlats createAndRetrievedAllFlats) {
        this.createAndRetrievedAllFlats = createAndRetrievedAllFlats;
    }

    @ResponseBody
    @PostMapping(value = "/create")
    CreateFlatResponseJSON createFlat(@RequestHeader("Authorization") String authorization,@Valid  @RequestBody CreateFlatRequestJSON requestJSON) throws GenericInputErrorException {
        CreateFlatResponse response=createAndRetrievedAllFlats.createFlat(requestJSON.getCreateFlatRequest());
        return new CreateFlatResponseJSON(response.getCreatedDate(),response.getId(),response.getName());
    }
    @GetMapping(value = "/view/flats")
    List<AvailableFlatsJSON> getAllFlats(@RequestHeader("Authorization") String authorization){
    return createAndRetrievedAllFlats.retrievedAllFlats().stream().map(a->new AvailableFlatsJSON(a.getId(),a.getName(),a.getDescription(),a.getPrice(),
            new AvailableBlockResponseJSON(a.getBlock().getId(),a.getBlock().getName(),a.getBlock().getNumberOfFlats()))).collect(Collectors.toList());
   }

}
