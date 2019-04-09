package com.amos.tenant.management.infrastructure.controllers;

import com.amos.tenant.management.infrastructure.data.*;
import com.amos.tenant.management.usecases.FlatService;
import com.amos.tenant.management.usecases.exceptions.GenericInputErrorException;
import com.amos.tenant.management.usecases.models.CreateFlatReponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController("api/v1/flats")
public class FlatController {
    @Autowired
    FlatService flatService;

    @PostMapping(value = "/flat")
    @ResponseBody
    CreateFlatResponseJSON creatFlat(@Valid  @RequestBody CreateFlatRequestJSON requestJSON) throws GenericInputErrorException {
        System.out.println("Amos is here controller");
        CreateFlatReponse flatReponse= flatService.createFlat(requestJSON.getCreatFlatRequest());
        return new CreateFlatResponseJSON(flatReponse.getId(),flatReponse.getName());
    }
    @GetMapping(value = "/viewflats")
    List<AvailableFlatResponseJSON> getAllFlats(){
        return flatService.viewAll().stream().
                map(a-> new AvailableFlatResponseJSON(a.getId(),a.getName(),a.getNumber(),
                        new AvailableEstateReponseJSON(a.getEstate().getId(),a.getEstate().getName(),a.getEstate().getCreateDate(),
                                new AddressJSON(a.getEstate().getAddress().getCity(),a.getEstate().getAddress().getPlot(),a.getEstate().getAddress().getStreet(),a.getEstate().getAddress().getTown()
                                )))).collect(Collectors.toList());
    }

}
